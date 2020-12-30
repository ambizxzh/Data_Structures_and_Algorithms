package E37_20201227_105_buildTree;

import java.util.*;

public class E37_20201217_105_buildTree {
    //E37.从前序与中序遍历序列构造二叉树 问题来源：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public static void main(String[] args){
        int[] a={3,9,20,15,7};
        int[] b={9,3,15,20,7};
        Solution solution=new Solution();
        TreeNode treeNode=solution.buildTree(a,b);
        System.out.println("End...");
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    //解题参考:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/
    private int[] preorder;
    private Map<Integer,Integer> indexMap;//各级递归需要用到的公共外部参数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //对于任意一棵树，前序遍历序列的特点:[根节点,[左子树的前序遍历结果],[右子树的前序遍历结果]]
        //对于任意一棵树，中序遍历序列的特点:[[左子树的中序遍历结果],根节点,[右子树的中序遍历结果]]
        int pre_length=preorder.length;
        int in_length=inorder.length;
        if(pre_length!=in_length){
            throw new RuntimeException("incorrect input");
        }
        this.preorder=preorder;
        this.indexMap=new HashMap<>();
        for(int i=0;i<in_length;i++){
            indexMap.put(inorder[i],i);
        }

        return buildTree(0,pre_length-1,0,in_length-1);
    }
    /**
     * @param preLeft 二叉树前序遍历的左边界
     * @param preRight 二叉树前序遍历的右边界
     * @param inLeft 二叉树中序遍历的左边界
     * @param inRight 二叉树中序遍历的右边界
     * */

    private TreeNode buildTree(int preLeft,int preRight,int inLeft,int inRight){
        //按照国际惯例，先写递归的终止条件
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }
        //在前序遍历中找到该层次下的根节点
        int valueRoot=preorder[preLeft];
        TreeNode root=new TreeNode(valueRoot);
        int indexRoot=indexMap.get(valueRoot);
        root.left=buildTree(preLeft+1,preLeft+(indexRoot-inLeft),inLeft,indexRoot-1);//(indexRoot-inLeft)代表左子树的实际长度
        root.right=buildTree(preLeft+(indexRoot-inLeft)+1,preRight,indexRoot+1,inRight);

        return root;
    }
}
