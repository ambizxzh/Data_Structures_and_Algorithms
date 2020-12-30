package E40_20201229_108_sortedArrayToBST;

public class E40_20201229_108_sortedArrayToBST {
    public static void main(String[] args){
        int[] array={-10,-3,0,5,9};
        Solution solution=new Solution();
        TreeNode treeNode=solution.sortedArrayToBST(array);
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
    private int[] array;
    public TreeNode sortedArrayToBST(int[] nums) {
        int length=nums.length;
        //这个直接在递归中就可以覆盖到
//        if(length==0){
//            return null;
//        }
        this.array=nums;

        return sortedArrayToBST(0,length-1);
    }
    private TreeNode sortedArrayToBST(int left_edge,int right_edge){
        //递归返回条件
        if(left_edge>right_edge){
            return null;
        }

        int mid=(right_edge-left_edge)/2+left_edge;//这里一定要注意递归的左边界来界定，位置在中间的点，即式子中的两个left_edge偏移量
        TreeNode root=new TreeNode(array[mid]);
        //构建root的左右子树，递归的第二个重要性就是边界的偏移量的处理
        root.left=sortedArrayToBST(left_edge,mid-1);
        root.right=sortedArrayToBST(mid+1,right_edge);
        return root;
    }
}
