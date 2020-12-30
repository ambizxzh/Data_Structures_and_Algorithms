package E01_20201106_1356_sortByBits;

import java.util.*;

public class E01_20201106_1356_sortByBits {
    //E01问题来源:https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,3,4,5,6,7,8};
        Solution solution=new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
    }
//    public int[] sortByBits(int[] arr) {
////        1 <= arr.length <= 500
////        0 <= arr[i] <= 10^4   2^14>10^4
//        ArrayList<LinkedList<Integer>> bucketSet=new ArrayList<>();//桶需要频繁插入数据，使用LinkedList
//        for(int index_bucket=0;index_bucket<15;index_bucket++){
//            //先新建目标数量的桶(bucket)，并将桶放在桶的集合(bucketSet)中
//            bucketSet.add(new LinkedList<>());
//        }
//
//        for (int integer : arr) {
//            int n = integer;
//            int remainder = 0;
//            int countOne = 0;
//            while (n != 0) {
//                remainder = n % 2;
//                n = n / 2;
//                if (remainder == 1 || n == 1) {
//                    countOne++;
//                }
//            }
//        }
//        return null;
//    }
//    public static void sortInsert(List<Integer> bucket, int integer){//进行桶内排序
//        ListIterator<Integer> iterator = bucket.listIterator();
//        boolean insertFlag=true;//桶内排序
//        while(iterator.hasNext()){
//            if(integer<iterator.next()){
//                iterator.previous();//迭代器往回走一步
//                iterator.add(integer);//在迭代器当前插入数据
//                insertFlag = false;
//                break;
//            }
//        }
//        if(insertFlag){//如果是桶内排序的话，将数据放在桶的末尾
//            bucket.add(integer);
//        }
//    }



}
class Solution{
    public int[] sortByBits(int[] arr) {
//        int[] array = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            array[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
//        }
//        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            array[i] = array[i] % 10000000;
//        }
//        return array;

        int[] array = new int[arr.length];
        int base = 1000000;//0 <= arr[i] <= 10^4,且2^14>10^4,所以base的长度是4+length_char(14)=6
        for(int i=0;i<arr.length;i++){
            // array[i]=getBitCount(arr[i]) * base + arr[i];//使用数组存储了两组信息
            array[i]=Integer.bitCount(arr[i]) * base + arr[i];//使用数组存储了两组信息
        }
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            array[i] = array[i] % base;
        }
        return array;
    }
    private int getBitCount(int integer){
        int count=0;
        int remainder = 0;
        while (integer != 0) {
            remainder = integer % 2;
            if (remainder == 1 || integer == 1) {
                count++;
            }
            integer =  integer / 2;
        }
        return count;
    }
}
