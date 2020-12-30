package E17_20201127_274_hIndex;

import java.util.Arrays;

public class E17_20201127_274_hIndex {
    //E17 274.H指数问题来源:https://leetcode-cn.com/problems/h-index/
    public static void main(String[] args){
        int[] citations={100};//3,0,6,1,5
        Solution solution=new Solution();
        System.out.println(solution.hIndex(citations));
    }
}
class Solution{
    public int hIndex(int[] citations){
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int h=0;
        while(h<citations.length){
            if(citations[h]>=citations.length-h){
                return citations.length-h;
            }
            h++;
        }
        return 0;
    }
}
