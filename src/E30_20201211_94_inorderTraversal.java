package E30_20201211_94_inorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E30_20201211_94_inorderTraversal {
    public static void main(String[] args){
        int[] array={1,-1,2};
        TreeNode treeNode=treeInit(array);
        Solution solution=new Solution();
        List<Integer> list=solution.inorderTraversal(treeNode);
        if(list!=null){
            for(int temporary:list){
                System.out.print(temporary);
            }
        }

    }
    public static TreeNode treeInit(int[] data){
        if(data.length==0){
            return null;
        }
        List<TreeNode> list=new ArrayList<>();
        for(int temporary:data){
            list.add(new TreeNode(temporary));
        }
        int list_size=list.size();
        for(int index=0;index<list_size/2;index++){
            if((2*index+1)<list_size&&list.get(2*index+1).val!=-1){
                if(list.get(index).val==-1){
                    list.get(index+1).left=list.get(2*index+1);
                }else{
                    list.get(index).left=list.get(2*index+1);
                }

            }
            if((2*index+2)<list_size&&list.get(2*index+2).val!=-1){
                list.get(index).right=list.get(2*index+2);
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
    List<Integer> list=new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}