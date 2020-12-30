package E33_20201215_96_numTrees;

public class E33_20201215_96_numTrees {
    //E33 96.不同的二叉搜索树1(求个数) 问题来源:https://leetcode-cn.com/problems/unique-binary-search-trees/
    public static void main(String[] args){
        int n=3;
        Solution solution=new Solution();
        System.out.println(solution.numTrees(n));
    }
}
class Solution {
    public int numTrees(int n) {//卡特兰数的求法
        long C=1;
        for(int i=0;i<n;i++){
            C=C*2*(2*i+1)/(i+2);
        }
        return (int) C;
    }
}