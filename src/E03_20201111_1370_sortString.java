package E03_20201111_1370_sortString;


public class E03_20201111_1370_sortString {
    //E03问题来源:https://leetcode-cn.com/problems/increasing-decreasing-string/
    //桶排序
    public static void main(String[] args) {
        String s="aaaabbbbcccc";
        Solution solution=new Solution();
        System.out.println(solution.sortString(s));
    }
}

class Solution {
    public String sortString(String s) {
        int length_s=s.length();
        StringBuilder result=new StringBuilder();
        int[] bucket=new int[26];//使用桶来分别给26个字母进行计数
        for(int index_bucket_init=0;index_bucket_init<length_s;index_bucket_init++){
            bucket[s.charAt(index_bucket_init)-'a']++;
        }
        while(result.length()<length_s){

            //先按由小到大扫描一遍
            for(int index_min2max=0;index_min2max<26;index_min2max++){
                if(bucket[index_min2max]>0){
                    result.append((char) (index_min2max+'a'));
                    bucket[index_min2max]--;
                }
            }
            //然后按由大到小扫描一遍
            for(int index_max2min=26-1;index_max2min>=0;index_max2min--){
                if(bucket[index_max2min]>0){
                    result.append((char) (index_max2min+'a'));
                    bucket[index_max2min]--;
                }
            }
        }

        return result.toString();
    }
}
