package E19_20201129_976_largestPerimeter;

import java.util.Arrays;

public class E19_20201129_976_largestPerimeter {
    //E19 976.三角形的最大周长 问题来源:https://leetcode-cn.com/problems/largest-perimeter-triangle/
    public static void main(String[] args){
        int[] array={2,1,2};
        Solution solution=new Solution();
        System.out.print(solution.largestPerimeter(array));
    }
}
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int index=A.length-1;index>=2;index--){
            if(A[index-1]+A[index-2]>A[index]){

                return A[index]+A[index-1]+A[index-2];
            }
        }
        return 0;
    }
}
