package E04_20201112_922_sortArrayByParityII;

import java.util.Arrays;

public class E04_20201112_922_sortArrayByParity {
    //E04问题来源:https://leetcode-cn.com/problems/sort-array-by-parity-ii/
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] A={4,2,5,7};
        System.out.println(Arrays.toString(solution.sortArrayByParityII(A)));

    }
}
class Solution{
    public int[] sortArrayByParityII(int[] A){
        int length=A.length;
        int[] result=new int[length];
        int index_odd=0;
        int index_even=0;
        for(int a:A){
            if(a%2==0){//为偶数
                result[2*index_even]=a;
                index_even++;
            }else{
                result[2*index_odd+1]=a;
                index_odd++;
            }
        }
        return result;
    }
}
