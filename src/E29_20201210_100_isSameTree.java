package E29_20201210_100_isSameTree;

import java.util.ArrayList;
import java.util.List;

public class E29_20201210_100_isSameTree {
    //E29 100.相同的树 问题来源:https://leetcode-cn.com/problems/same-tree/
    public static void main(String[] args){
        int[] array={1,-1,3};
        int[] array2={1,2,3};
        TreeNode treeNode=treeInit(array);
        TreeNode treeNode2=treeInit(array2);
        Solution solution=new Solution();

        System.out.println(solution.isSameTree(treeNode,treeNode2));
    }
    public static TreeNode treeInit(int[] data){//根据数组的存储形式初始化一个树。使用中序遍历初始化
        if(data.length==0){
            return null;
        }
        List<TreeNode> list=new ArrayList<>();//新建一个数组链表，存储树的节点
        for(int temporary:data){
            list.add(new TreeNode(temporary));
        }
        int size_list=list.size();
        for(int index=0;index<size_list/2;index++){
            if((2*index+1)<size_list&&list.get(2*index+1).val!=-1){
                list.get(index).left=list.get(2*index+1);
            }
            if((2*index+2)<size_list&&list.get(2*index+2).val!=-1){
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);//递归的返回值要作为上一级的
        }
    }
}