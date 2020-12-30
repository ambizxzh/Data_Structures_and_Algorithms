package E36_20201225_103_zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E36_20201225_103_zigzagLevelOrder {
    public static void main(String[] args){
        int[] array={3,9,20,-1,-1,15,7};//{3,9,20,-1,-1,15,7};1,2,3,4,-1,-1,5
        TreeNode root=treeInitByInOrderTraverse(array);
        Solution solution=new Solution();
        List<List<Integer>> result=solution.zigzagLevelOrder(root);
        System.out.println("end...");
    }
    public static TreeNode treeInitByInOrderTraverse(int[] array){
        List<TreeNode> list=new ArrayList<>();
        for(int a:array){
            list.add(new TreeNode(a));
        }
        int list_size=list.size();
        for(int index=0;index<list_size/2;index++){
            int left=2*index+1;
            int right=2*index+2;
            int count;
            if(left<list_size&&list.get(left).val!=-1){//左子节点不为空
                count=index;
                while(list.get(count).val==-1){count++;}//根节点不为空
                list.get(index).left=list.get(left);
            }
            if(right<list_size&&list.get(right).val!=-1){
                count=index;
                while(list.get(count).val==-1){count++;}
                list.get(count).right=list.get(right);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> list=new ArrayList<>();
        boolean zigzagFlag=false;
        list.add(root);
        while(!list.isEmpty()){
            List<Integer> level=new ArrayList<>();//存储每一层的数据
            int currentSize=list.size();
            for(int index=0;index<currentSize;index++){

                TreeNode treeNode=list.remove(0);

                level.add(treeNode.val);
                if(treeNode.left!=null){
                    list.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    list.add(treeNode.right);
                }
            }
            if(zigzagFlag){//进行逆序
                int level_size=level.size();
                for(int i=0;i<level_size/2;i++){
                    int right=level_size-1-i;
                    int temp=level.get(right);
                    level.set(right,level.get(i));
                    level.set(i,temp);
                }
            }
            zigzagFlag=!zigzagFlag;
            result.add(level);

        }

        return result;
    }
}