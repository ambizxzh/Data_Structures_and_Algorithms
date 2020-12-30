package E25_20201203_86_partition;

public class E25_20201203_86_partition {
    public static void main(String[] args){
        //E25 86.分隔链表 问题来源:https://leetcode-cn.com/problems/partition-list/
        int[] array={4,1};
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        Solution solution=new Solution();

        ListNode result=solution.partition(sentry.next,3);
        while(result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode partition(ListNode head, int x) {
        //类似的解决方案，但时间复杂度更低:https://leetcode-cn.com/problems/partition-list/solution/liang-ge-zi-lian-biao-pin-jie-han-zhu-shi-ji-bai-1/
        //边界条件
        if(head==null||head.next==null){return head;}
        ListNode sentry=new ListNode(-1);
        sentry.next=head;
        ListNode pre=sentry;
        while(pre.next.next!=null){
            if(pre.next.val>=x&&pre.next.next.val<x){
                ListNode temporary=pre.next.next;
                pre.next.next=pre.next.next.next;
                temporary.next=pre.next;
                pre.next=temporary;
                pre=sentry;
            }else{
                pre=pre.next;
            }
        }
        return sentry.next;
    }
}