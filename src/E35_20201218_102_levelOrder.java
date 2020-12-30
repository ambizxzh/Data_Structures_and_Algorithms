package E35_20201218_102_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E35_20201218_102_levelOrder {
    //E35 102.二叉树的层序遍历 问题来源：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    public static void main(String[] args){
        int[] array={3,9,20,-1,-1,15,7};
        TreeNode root=treeInitByInTraverse(array);
        Solution solution=new Solution();
        List<List<Integer>> list=solution.levelOrder(root);
        System.out.print("end...");
    }
    private static TreeNode treeInitByInTraverse(int[] data){
        List<TreeNode> list=new ArrayList<>();
        for(int d:data){
            list.add(new TreeNode(d));
        }
        int list_size=list.size();
        int count=0;//count用来避开 给空节点操作赋值子树
        for(int index=0;index<list_size/2;index++){//index代表树的节点索引，l、r代表左子树、右子树在链表中的位置
            //左子树
            int l=2*index+1;
            if(l<list_size&&list.get(l).val!=-1){
                count=index;
                while(list.get(count).val==-1){
                    count++;
                }
                list.get(count).left=list.get(l);
            }
            //右子树
            int r=2*index+2;
            if(r<list_size&&list.get(r).val!=-1){
                count=index;
                while(list.get(count).val==-1){
                    count++;
                }
                list.get(count).right=list.get(r);
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
class Solution {//抓住层序遍历的一些特性，选用队列(链表的一种，即链表也行)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {//树是一种二维结构，所以使用了双循环(while和for，
            // while负责不以索引为标志位的遍历结构(以结尾或者结构为空为标志位,这里并不知道层数，所以使用while),
            // for负责每一层遍历该层的大小次数)
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
