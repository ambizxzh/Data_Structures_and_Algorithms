package E20_20201130_21_mergeTwoLists;

public class E20_20201130_21_mergeTwoLists {
    //E20 21.合并两个有序链表 问题来源:https://leetcode-cn.com/problems/merge-two-sorted-lists/
    public static void main(String[] args){
        int[] array1={1,3,4};
        int[] array2={1,2,4};
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array1){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode head1=sentry.next;

        ListNode sentry1=new ListNode(-1);
        ListNode pre1=sentry1;
        pre1=sentry1;
        for(int arr:array2){
            pre1.next=new ListNode(arr);
            pre1=pre1.next;
        }
        ListNode head2=sentry1.next;

        Solution solution=new Solution();
        ListNode result=solution.mergeTwoLists(head1,head2);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        while(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    pre.next=new ListNode(l1.val);
                    l1=l1.next;
                }else{
                    pre.next=new ListNode(l2.val);
                    l2=l2.next;
                }
                pre=pre.next;

//            else if(l1!=null){
//                pre.next=new ListNode(l1.val);
//                pre=pre.next;
//                l1=l1.next;
//            }
//            else{
//                pre.next=new ListNode(l2.val);
//                pre=pre.next;
//                l2=l2.next;
//            }
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next=l1==null?l2:l1;
        return sentry.next;
    }
}