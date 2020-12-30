package E26_20201204_237_deleteNode;

public class E26_20201204_237_deleteNode {
    public static void main(String[] args){
        int[] array={1,2,3,4,5,6};
        int num=3;
        ListNode node;
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode head=sentry.next;
        for(int index=0;index<num-1;index++){
            head=head.next;
        }
        node=head;
        Solution solution=new Solution();
        solution.deleteNode(node);
        head=sentry.next;
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}