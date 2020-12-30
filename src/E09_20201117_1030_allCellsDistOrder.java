package E09_20201117_1030_allCellsDistOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class E09_20201117_1030_allCellsDistOrder {
    //E09 1030.距离顺序排列矩阵单元格(曼哈顿距离) 问题来源:https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
    //推荐阅读解法:https://leetcode-cn.com/problems/matrix-cells-in-distance-order/solution/si-chong-jie-fa-shu-zu-pai-xu-tong-pai-xu-bfs-mo-n/
    public static void main(String[] args){
        int R=2,C=3,r0=1,c0=2;
        Solution solution=new Solution();
        System.out.print(Arrays.toString(solution.allCellsDistOrder(R, C, r0, c0)));
    }
}
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//        1 <= R <= 100
//        1 <= C <= 100
//        0 <= r0 < R
//        0 <= c0 < C

        //可以根据数的进制来模拟桶排序
//        int[] start={r0, c0};
        int[] bucket_scaleConversion=new int[R*C];//桶的数量
        int base1=1000;//单方向上直线最大距离为100(即100-0),使用1000可以装下100这个三位数,用来进位
        int base=1000000;//base是每个桶能装的数据的数量:距离为1的点数最多为4=(1+1)^2,距离为2的点最多为9=(2+1)^2...结合上面的分析,因而定为1000000
        //数据压缩到桶内
        int i=0;
        for(int r1=0;r1<R;r1++){
            for(int c1=0;c1<C;c1++){
                int n = Math.abs(r1-r0)+Math.abs(c1-c0);
                bucket_scaleConversion[i]=n * base + r1*base1+c1;//n * base表示距离为n的桶
                i++;
//                bucket_scaleConversion[getManhattanDistance(r1,c1,start)]=getManhattanDistance(r1,c1,start) * base + getManhattanDistance(r1,c1,start);
            }
        }

        //进行排序
        Arrays.sort(bucket_scaleConversion);
        //将数据从桶中解压出来
        int[][] result=new int[bucket_scaleConversion.length][2];
        for(int index=0;index<bucket_scaleConversion.length;index++){
            bucket_scaleConversion[index]=bucket_scaleConversion[index]%base;
            int r=bucket_scaleConversion[index]/base1;
            int c=bucket_scaleConversion[index]%base1;
            result[index]=new int[]{r,c};
        }
        return result;
    }
//    private int getManhattanDistance(int r,int c,int[] start){
//        return Math.abs(r-start[1])+Math.abs(c-start[2]);
//    }
}
