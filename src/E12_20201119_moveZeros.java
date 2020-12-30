package E12_20201119_283_moveZeroes;

public class E12_20201119_moveZeros {
    public static void main(String[] args){
        int[] array={0,1,0,3,12};
        Solution solution=new Solution();
        solution.moveZeroes(array);
    }
}
//class Solution {
//    public void moveZeroes(int[] nums) {
//        if(nums==null || nums.length==1){
//            return;
//        }
//        //使用双指针法
//        int length=nums.length;
//        int zeroFilled=length-1;
//        for(int nums_index=length-1;nums_index>=0;nums_index--){//反方向遍历
//            if(nums[nums_index]==0){
//                int move_index=nums_index;
//                for(;move_index<zeroFilled;move_index++){
//                    nums[move_index]=nums[move_index+1];
//                }
//                nums[move_index]=0;
//                zeroFilled--;
//            }
//        }
//        for(int arr:nums){
//            System.out.println(arr);
//        }
//    }
//}
class Solution {//双指针 ，使用快排思想以0为中间节点进行交换 解题思路优化来源:https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {//如果节点不为0，则交换
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

