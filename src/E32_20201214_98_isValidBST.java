package E32_20201214_98_isValidBST;

import java.util.ArrayList;
import java.util.List;

public class E32_20201214_98_isValidBST {
    //E32 98.验证二叉搜索树 问题来源:https://leetcode-cn.com/problems/validate-binary-search-tree/
    public static void main(String[] args){
        int[] array={2,1,3};
        Solution solution=new Solution();
        TreeNode treeNode=treeInitByInTraverse(array);
        boolean a=solution.isValidBST(treeNode);
        System.out.println(a);
    }
    public static TreeNode treeInitByInTraverse(int[] data){//使用中序遍历的数组，初始化二叉树
        if(data.length==0){return new TreeNode();}
        List<TreeNode> list=new ArrayList<>();
        for(int value:data){
            list.add(new TreeNode(value));
        }
        int list_size=list.size();
        int count=0;
        for(int index=0;index<list_size/2;index++){
            if((2*index+1)<list_size&&list.get(2*index+1).val!=-1){
                count=index;
                while(list.get(index).val==-1){
                    count++;
                }
                list.get(count).left=list.get(2*index+1);
            }
            if((2*index+2)<list_size&&list.get(2*index+2).val!=-1){
                count=index;
                while(list.get(index).val==-1){
                    count++;
                }
                list.get(count).right=list.get(2*index+2);
            }
        }
        return list.get(0);
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
    long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {//中序遍历
        if(root==null) return true;
        boolean l= isValidBST(root.left);
        if(root.val<=pre) return false;
        pre=root.val;
        boolean r=isValidBST(root.right);
        return l&&r;
    }
}