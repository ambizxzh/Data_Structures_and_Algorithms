package E21_20201130_61_rotateRight;

public class E21_20201130_61_rotateRight {
    //E21 61.旋转链表 问题来源:https://leetcode-cn.com/problems/rotate-list/
    public static void main(String[] args){
        int[] array={1,2,3,4,5};
        int k=3;
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        Solution solution=new Solution();

        ListNode result=solution.rotateRight(sentry.next,k);
        while(result!=null){
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){return null;}
        ListNode sentry=new ListNode(-1);
        sentry.next=head;
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        head=sentry.next;
        int rotateNumber=length-k%length;
        if(rotateNumber==length){
            return sentry.next;
        }
        for(int count=0;count<rotateNumber-1;count++){
            head=head.next;
        }
        ListNode rear=head.next;
        head.next=null;
        ListNode pre=sentry.next;
        sentry.next=rear;
        while(rear.next!=null){
            rear=rear.next;
        }
        rear.next=pre;
        return sentry.next;
    }
}