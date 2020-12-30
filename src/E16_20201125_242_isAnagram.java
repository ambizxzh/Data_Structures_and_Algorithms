package E16_20201125_242_isAnagram;

import java.util.HashMap;
import java.util.Map;

public class E16_20201125_242_isAnagram {
    public static void main(String[] args){
        String s="anagram";
        String t="nagaram";
        Solution solution=new Solution();
        System.out.println(solution.isAnagram(s,t));
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> map=new HashMap<>();
        for(int index_s=0;index_s<s.length();index_s++){
            char c=s.charAt(index_s);
            map.put(c,map.getOrDefault(c,0)+1);//原来不知道有这个getOrDefault方法修改的思路来源:https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
        }
        for(int index_t=0;index_t<t.length();index_t++){
            char c=t.charAt(index_t);
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0){
                return false;
            }
        }
        return true;
    }
}