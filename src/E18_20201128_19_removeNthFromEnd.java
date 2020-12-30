package E18_20201128_19_removeNthFromEnd;

public class E18_20201128_19_removeNthFromEnd {
    public static void main(String[] args){
        //E18 19.删除列表的倒数第N个节点 问题来源:https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
        int[] array={1,2,3,4,5};
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }

        Solution solution=new Solution();
        ListNode result=solution.removeNthFromEnd(sentry.next,2);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //解题方法:使用哨兵和指针
        ListNode sentry=new ListNode(-1);
        sentry.next=head;
        int length=0;
        while(head!=null){
            head=head.next;
            length++;
        }
        ListNode pre=sentry;
        for (int index=0;index<length-n;index++){
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return sentry.next;
    }
}
