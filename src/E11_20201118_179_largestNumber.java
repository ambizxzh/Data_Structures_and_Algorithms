package E11_20201118_179_largestNumber;

import java.util.*;

public class E11_20201118_179_largestNumber {
    //E11 179.找出最大的组合数(字节题库) 问题来源:https://leetcode-cn.com/problems/largest-number/
    //属于比较难想到的思路，没有使用经典的算法
    //解法:官方解法+逆序解法的解释 https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/  https://leetcode-cn.com/problems/largest-number/solution/4ms-ni-xu-dui-intzhuan-stringde-kuai-su-fang-fa-by/
    public static void main(String[] args){
        int[] array={3,30,34,5,9};
        Solution solution=new Solution();
        System.out.println(solution.largestNumber(array));
    }
}
class Solution {
//    public String largestNumber(int[] nums) {
//        StringBuilder result=new StringBuilder();
//        ArrayList<LinkedList<Integer>> buckets=new ArrayList<>();
//        for(int index=0;index<9;index++){//最高位的出现的数字的种类，即1~9共九个
//            buckets.add(new LinkedList<>());//添加桶
//        }
//
//        for(int arr:nums){
//            LinkedList<Integer> list=buckets.get(getTopDigitNumber(arr)-1);//取一个桶种的物品，用来串连添加
//            list.add(arr);
//        }
//        return result.toString();
//    }
//    private int getTopDigitNumber(int n){
//        int calc=0;
//        while(n!=0){
//            calc=n;
//            n=n/10;
//        }
//        return calc;
//    }
public String largestNumber(int[] nums){
    //将数组中的数字转换成字符串,存储在字符串数组中
    String[] stringArray=new String[nums.length];
    for(int number_index=0;number_index<nums.length;number_index++){
        stringArray[number_index]=String.valueOf(nums[number_index]);
    }
    //使用非传统经典算法进行排序，而是使用减少逆序对的方法进行排序
    Arrays.sort(stringArray,new largestNumberCompare());

    if(stringArray[0].equals("0")){//如果排序后，数组的最大值只包含0，直接输出0即可
        return "0";
    }
    String resultString=new String();
    for(String s:stringArray){
        resultString+=s;
    }
    return resultString;
}
private static class largestNumberCompare implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        return (s2+s1).compareTo(s1+s2);//消除逆序。这里的意思是如果(s2+s1)>(s1+s2)则进行交换，即存在逆序则进行交换
    }
}
}