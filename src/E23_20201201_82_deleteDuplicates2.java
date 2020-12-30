package E23_20201201_82_deleteDuplicates2;

public class E23_20201201_82_deleteDuplicates2 {
    //E23 82.删除排序链表中的重复元素2 问题来源:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
    public static void main(String[] args){
        int[] array={1,1,1,2,3};
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

//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//
//        if(head==null){return null;}
//        ListNode sentry=new ListNode(-1);
//        sentry.next=head;
//        ListNode pre=sentry;
//        ListNode point=head;
//        boolean flag_delete=false;
//
//        while(point.next!=null){
//            if(point.val==point.next.val){
//                point=point.next;
//                flag_delete=true;
//            }else{
//                point=point.next;
//                if (flag_delete){
//                    pre.next=point;
//                    flag_delete=false;
//                }else{
//                    pre=pre.next;
//                }
//            }
//        }
//        if (flag_delete){
//            pre.next=point.next;
//        }
//        return sentry.next;
//    }
//}

//另一种解法:递归:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javadi-gui-0ms-by-maplestore/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        if(head.val==head.next.val){
            while(head!=null&&head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next=deleteDuplicates(head.next);
            return head;
        }
    }
}