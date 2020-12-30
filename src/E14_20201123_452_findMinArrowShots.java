package E14_20201123_452_findMinArrowShots;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class E14_20201123_452_findMinArrowShots {
    //E14 452.用最少数量的箭引爆气球 问题来源:https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
    //解题思路:与E10相似，E10是求并集即合并区间，E14这个是求交集
    public static void main(String[] args){
//        int[][] array={{-2147483646, -2147483645},{2147483646, 2147483647}};//{{1,2},{3,4},{5,6},{7,8}} {{10, 16}, {2, 8}, {1, 6}, {7, 12}} {{-2147483646, -2147483645},{2147483646, 2147483647}}
        int[][] array= {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        Solution solution=new Solution();
        System.out.println(solution.findMinArrowShots(array));
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        //1st step:先对区间进行排序
        // Arrays.sort(points, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] ints1, int[] ints2) {
        //         return ints1[0]-ints2[0];
        //     }
        // });

//        Arrays.sort(points, (a1,a2)->(a1[0]<a2[0]?-1:1));//为了防止相减带来溢出，最好不要使用 a1[0]-a2[0],而是使用a1[0]<a2[0]?-1:1
//        //2nd step:求交集
//        List<int[]> result=new LinkedList<>();
//        for(int[] arr:points){
//            int left=arr[0],right=arr[1];
//            if(result.size()==0||result.get(result.size()-1)[1]<left){
//                result.add(new int[]{left,right});
//            }else{
//                result.get(result.size()-1)[0]=left;
//                result.get(result.size()-1)[1]=Math.min(right,result.get(result.size()-1)[1]);
//            }
//        }
//
//        return result.size();
        //另一种解法2nd step:直接对前一个区间右边大于当前区间左边的计数。排序用得数字不同
        Arrays.sort(points, new Comparator<int[]>() {//这里取得是区间右边
            @Override
            public int compare(int[] ints1, int[] ints2) {
                if(ints1[1]<ints2[1]){return -1;}
                else if(ints1[1]>ints2[1]){return 1;}
                else{return 0;}
            }
        });
        int count=1;
        int pre=points[0][1];//第一个区间右边
        for(int[] arr:points){
            if(arr[0]>pre){
                pre=arr[1];
                count++;
            }
        }
        return count;

    }
}