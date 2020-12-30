package E02_20201109_973_kClosest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class E02_20201109_973_kClosest {
    //E02问题来源:https://leetcode-cn.com/problems/k-closest-points-to-origin/

    public static void main(String[] args){

//        int[][] a ={{1,3},{-2,2}};
//        int k=1;
        int[][] a={{3,3},{5,-1},{-2,4}};
        int k=2;
        Solution solution=new Solution();
        System.out.println(Arrays.toString(solution.kClosest(a,k)[0]).toString() + Arrays.toString(solution.kClosest(a,k)[1]).toString());

    }
}
class Solution {
//            1 <= K <= points.length <= 10000
//            -10000 < points[i][0] < 10000
//            -10000 < points[i][1] < 10000
    public int[][] kClosest(int[][] points, int K) {
//        //方法一，直接排序，然后取前K个值
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] ints1, int[] ints2) {//比较器，对数组进行排序,比较，得到优先的值
//                return (ints1[0]*ints1[0]+ints1[1]*ints1[1])-(ints2[0]*ints2[0]+ints2[1]*ints2[1]);
//            }
//        });
//        return Arrays.copyOfRange(points,0,K);
        //方法二，使用堆来的到TopK的值
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((p1,p2)->p2[0]*p2[0]+p2[1]*p2[1]-(p1[0]*p1[0]-p1[1]*p1[1]));
        //(p1,p2)->(p2[0]*p2[0]+p2[1]*p2[1]-(p1[0]+p1[0]+p1[1]+p1[1]))是比较器的在该问题上的比较格式，默认是小根堆(求前K大)，所以是p2相关的减去p1相关的值
        for(int[] point:points){
            if(priorityQueue.size()<K){
                priorityQueue.offer(point);
            }else if(priorityQueue.comparator().compare(point,priorityQueue.peek())>0){//取堆中最大值与当前值比较，若当前值更小，则替换刚刚堆中用于比较的值
                priorityQueue.poll();
                priorityQueue.offer(point);
            }
        }

        //将TopK的值从堆中取出来，给需要输出(返回)的数组格式
        int[][] result=new int[priorityQueue.size()][2];
        int idx=0;
        for(int[] res:priorityQueue){
            result[idx++]=res;
        }
        return result;
    }
}
