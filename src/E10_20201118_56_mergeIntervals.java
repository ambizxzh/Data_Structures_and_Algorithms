package E10_20201118_56_mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E10_20201118_56_mergeIntervals {
    //E10 56.合并区间 问题来源:https://leetcode-cn.com/problems/merge-intervals/
    public static void main(String[] args){
        int[][] array= {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        Solution solution=new Solution();
        int[][] result=solution.merge(array);
        for(int[] res:result){
            System.out.print(Arrays.toString(res));
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals,(arr1,arr2)->{
//            return Integer.compare(arr1[0],arr2[0]);
//        });//按照区间的左极限进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] inter1, int[] inter2) {//这个比较器比上面的Integer的比较器优秀
                return inter1[0]-inter2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
//        result.add(intervals[0]);
//        //按顺序从左至右依次合并
//        for(int index=1;index<intervals.length;index++){
//            if(result.get(result.size()-1)[1]>=intervals[index][0]){
//                result.add(new int[]{Math.min(result.get(result.size()-1)[0],intervals[index][0]),Math.max(result.get(result.size()-1)[1],intervals[index][1])});
//                result.remove(result.get(result.size()-2));
//            }else{
//                result.add(intervals[index]);
//            }
//        }
//        return result.toArray(new int[result.size()][]);
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < left) {//正常的不用合并,免得先压入result再合并导致需要更改比较大的操作
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
