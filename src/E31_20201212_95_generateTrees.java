package E31_20201212_95_generateTrees;

import java.util.LinkedList;
import java.util.List;

public class E31_20201212_95_generateTrees {
    //E31 95.不同的二叉搜索树2 问题来源:https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
    //要注意二叉搜索树(Binary Search Tree,BST)的特点:左子树节点的值<根节点的值<右子树节点的值,所有一直递归下去。同时兼具排序和树的特点，
    // 并且需要遍历任意一个值查看是否能作为某个子树的根节点，可以想到需要选取比较位的归并排序或快速排序
    public static void main(String[] args){
        int n=3;
        Solution solution=new Solution();
        solution.generateTrees(n);
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        List<TreeNode> list=generateTrees(1,n);
        return list;
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> TreeSet=new LinkedList<TreeNode>();
        if(start>end){//递归中断条件
            TreeSet.add(null);
            return TreeSet;
        }
        for(int i=start;i<=end;i++){//遍历所有可能的节点
            //获得所有可行的左子树
            List<TreeNode> leftTree= generateTrees(start,i-1);
            //获得所有可行的右子树
            List<TreeNode> rightTree=generateTrees(i+1,end);

            //将所有左子树与右子树，按阶段拼接
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                   TreeNode current=new TreeNode(i);
                    current.left=left;
                    current.right=right;
                    TreeSet.add(current);
                }
            }

        }
        return TreeSet;
    }
}