package E27_20201208_20_isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E27_20201208_20_isValid {
    //E27 20.有效的括号 题目来源:https://leetcode-cn.com/problems/valid-parentheses/
    //匹配问题：使用哈希表,减少情况数;二元匹配问题使用哈希表+栈
    public static void main(String[] args){
        String s="(){}{}[]";
        Solution solution=new Solution();
        System.out.println(solution.isValid(s));
    }
}
class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        if(len%2==1){
            return false;
        }
        Map<Character,Character> pairs=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack=new Stack<>();
        for(int index=0;index<len;index++){
            char c=s.charAt(index);
            if(pairs.containsKey(c)){//字符c是右括号，即哈希表的键
                if(stack.isEmpty()||stack.peek()!=pairs.get(c)){//栈为空，或者，栈顶值不等于哈希表的对应于字符c的值
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();//为空，则全部匹配完成。不为空，则有单个存在
    }
}