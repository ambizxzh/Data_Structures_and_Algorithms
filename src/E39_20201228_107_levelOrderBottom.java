package E39_20201228_107_levelOrderBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E39_20201228_107_levelOrderBottom {
    public static void main(String[] args){
        int[] array={3,9,20,-1,-1,15,7};
        TreeNode treeNode=treeInitByInTraverse(array);
        Solution solution=new Solution();
        List<List<Integer>> list=solution.levelOrderBottom(treeNode);
        System.out.println("end...");
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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //使用广度优先搜索算法进行层次遍历，每次遍历的值插入结果链表result_list的头部
        List<List<Integer>> result_list=new LinkedList<List<Integer>>();
        if(root==null){
            return result_list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queue_size=queue.size();
            List<Integer> breadth_list=new LinkedList<>();
            for(int i=0;i<queue_size;i++){//广度优先搜素
                TreeNode treeNode=queue.poll();
                breadth_list.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            result_list.add(0,breadth_list);
        }
        return result_list;
    }
}