package E15_20201124_164_maximumGap;

public class E15_20201124_164_maximumGap {
    public static void main(String[] args){
        int[] array={3,6,9,1};
        Solution solution=new Solution();
        System.out.println(solution.maximumGap(array));
    }
}
class Solution {
    //思路来源:https://leetcode-cn.com/problems/maximum-gap/solution/mei-xiang-dao-wo-men-zhi-jian-de-zui-da-jian-ju-ji/
    private static class Bucket{//自定义一个含有区间的桶的类
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
    }
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums)
        {
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        //假设相邻两个数之间的间隔都一样，此时该数组的最大间隔是 相同最大值、最小值和长度的数组 集合中的最小的最大间隔。以此大小来当作每个桶的大小
        int bucketSize=Math.max((max-min)/(nums.length-1),1);//计算每个桶的大小，与1比较取最大值是考虑原数组中数字都一样
        Bucket[] bucket=new Bucket[(max-min)/bucketSize+1];//(max-min)/bucketSize+1表示桶的个数
        //在一次迭代中尽量把该做的都做完
        for(int arr:nums){
            int local=(arr-min)/bucketSize;//找到数字在的桶的序号
            if(bucket[local]==null){
                bucket[local]= new Bucket();//
            }
            bucket[local].min=Math.min(bucket[local].min,arr);//找出每个桶中的最小值
            bucket[local].max=Math.max(bucket[local].max,arr);//找出每个桶中的最大值
        }
        int pre_bucketMax=Integer.MAX_VALUE;//用来存储已经遍历过的含有数字的桶(非空桶)的最大值
        int maxGap=Integer.MIN_VALUE;//用来记录最大间隔
        for(Bucket buc:bucket){
            if(buc!=null){//有些桶里没有数字，当桶里有数字才做处理
                if(pre_bucketMax!=Integer.MAX_VALUE){//这里表示进行过桶的最大值更新,即已经经过了第一个有数字的桶
                    maxGap=Math.max(maxGap,buc.min-pre_bucketMax);//当前最大间隔=Math.max(上次遍历时的最大间隔,(当前桶的最小值-上次遍历非空的桶的最大值))
                }
                pre_bucketMax=buc.max;//更新桶的最大值
                maxGap=Math.max(maxGap,buc.max-buc.min);//看看桶内的最大间隔
            }
        }
        return maxGap;
    }
}