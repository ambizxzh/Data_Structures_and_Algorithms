package E28_20201209_71_simplifyPath;

import java.util.LinkedList;
import java.util.List;

public class E28_20201209_71_simplifyPath {
    //E28 71.简化路径 问题来源:https://leetcode-cn.com/problems/simplify-path/
//    1,Unix 风格
//      一个点 (.) , 表示当前目录.
//      两个点 (..) , 表示上一级目录.
//      可以出现连续斜杠 (/)
//    2,规范路径
//      以 / 开头
//      两个目录之间, 只有一个斜杠.
//      最后一个目录名(如果存在), 不以 / 结尾.

    //解题思路
//    使用 arr.split() 方法, 以斜杠 (/) 为分隔符, 将 Unix 路径 path 拆分为若干字符串组成的数组.
//            将字符串顺序压入栈中
//    不包含元素, 一个点 (.) 时, 跳过.
//    两个点 (..) 时, 将当前栈顶元素移出栈.
    //路径中只能出现 英文字符、数字、斜杠(/)、句号(.)、连字符号(_)

    public static void main(String[] args){
        String s="/a//b////c/d//././/..";
        Solution solution=new Solution();
        System.out.println(solution.simplifyPath(s));
    }
}
class Solution {
    public String simplifyPath(String path) {
        List<String> pathStack=new LinkedList<>();
        String[] pathArr=path.split("/");
        for(String s:pathArr){
            if(!s.isEmpty()&&!s.equals(".")&&!s.equals("..")){
                pathStack.add(s);
            }
            if(s.equals("..")&&!pathStack.isEmpty()){//栈不为空，且遇到".."则出栈
                pathStack.remove(pathStack.size()-1);
            }
        }
        if(pathStack.isEmpty()){
            return "/";//如果栈为空，则直接返回"/"
        }
        StringBuilder result=new StringBuilder();
        for (String s : pathStack) {
            result.append("/").append(s);
        }
        return result.toString();
    }
}
