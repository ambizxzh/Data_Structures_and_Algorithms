package E34_20201217_101_isSymmetric;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E34_20201217_1010_isSymmetric {
    //E34 101.对称二叉树 问题来源:https://leetcode-cn.com/problems/symmetric-tree/submissions/
    //问题在于找出对称的现象的特征
    public static void main(String[] args){
        int[] array={1,2,2,3,4,4,3};
        TreeNode treeNode=treeInitByInTraverse(array);
        Solution solution=new Solution();
        System.out.println(solution.isSymmetric(treeNode));
    }
    public static TreeNode treeInitByInTraverse(int[] data){//使用中序遍历的数组，初始化二叉树
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
      TreeNode(int x) { val = x; }
  }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
//    //方法一：递归
//    public static boolean check(TreeNode p,TreeNode q){
//        if(p==null&&q==null){//节点同时为空
//            return true;
//        }
//        if(p==null||q==null){//节点只有一个为空(经过了上面的判断)
//            return false;
//        }
//        return p.val==q.val&&check(q.left,p.right)&&check(q.right,p.left);
//    }
    //方法二:迭代 引入队列：将递归程序写成迭代程序的一种方法
    public static boolean check(TreeNode p,TreeNode q){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            p=queue.poll();
            q=queue.poll();
            if(p==null&&q==null){
                continue;//不是return true;
            }
            if((p==null||q==null)||p.val!=q.val){
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}