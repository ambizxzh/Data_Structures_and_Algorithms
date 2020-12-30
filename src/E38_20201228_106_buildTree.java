package E38_20201228_106_buildTree;

import java.util.HashMap;
import java.util.Map;

public class E38_20201228_106_buildTree {
    public static void main(String[] args){
        int[] in_array={9,3,15,20,7};
        int[] post_array={9,15,7,20,3};
        Solution solution=new Solution();
        TreeNode treeNode=solution.buildTree(in_array,post_array);
        System.out.println("end..");
    }
}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    private Map<Integer,Integer> map;
    private int[] post_order;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length_in=inorder.length;
        int length_post=postorder.length;
        if(length_in!=length_post){
            throw new RuntimeException("Incorrect input");
        }
        this.map=new HashMap<>();
        this.post_order=postorder;
        for(int i=0;i<length_in;i++){
            map.put(inorder[i],i);
        }
        this.post_order=postorder;

        return buildTree(0,length_post-1,0,length_in-1);
    }
    private TreeNode buildTree(int postLeft,int postRight,int inLeft,int inRight){
        //先写递归终止条件
        if(postLeft>postRight||inLeft>inRight){
            return null;
        }
        //找到根节点的值,并生成节点
        TreeNode root=new TreeNode(post_order[postRight]);
        //找到根节点在中序遍历序列中的位置
        int in_loc=map.get(root.val);
        int offset=in_loc-inLeft;
        root.left=buildTree(postLeft,postLeft+offset-1,inLeft,in_loc-1);//关键在于找准边界
        root.right=buildTree(postLeft+offset,postRight-1,in_loc+1,inRight);
        return root;
    }
}