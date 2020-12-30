package E22_20201201_83_deleteDuplicates;

public class E22_20201201_83_deleteDuplicates {
    //E22 83.删除排序链表中的重复元素 问题来源:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
    public static void main(String[] args){
        int[] array={1,2,3,4,4};
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        Solution solution=new Solution();
        ListNode result=solution.deleteDuplicates(sentry.next);
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentry=new ListNode(-1);
        sentry.next=head;
        while(head!=null&&head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return sentry.next;
    }
}