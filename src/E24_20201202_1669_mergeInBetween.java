package E24_20201202_1669_mergeInBetween;

public class E24_20201202_1669_mergeInBetween {
    //E24 1669.合并两个链表 问题来源:https://leetcode-cn.com/problems/merge-in-between-linked-lists/
    public static void main(String[] args){
        int[] array1={0,1,2,3,4};
        int[] array2={1001,1002,1003,1004};
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array1){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode list1=sentry.next;
        sentry.next=null;
        pre=sentry;
        for(int arr:array2){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode list2=sentry.next;
        Solution solution=new Solution();
        ListNode result=solution.mergeInBetween(list1,1,1,list2);
        while(result!=null){
            System.out.print(result.val);
            System.out.print(" ");
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2rear;
        ListNode sentry=new ListNode(-1);
        sentry.next=list2;//保存list2
        //求出list2的尾部节点
        while(list2.next!=null){
            list2=list2.next;
        }
        list2rear=list2;
        list2=sentry.next;//还原list2，即让list2这个节点依然成为原链表的头节点

        //找出list1中的第a-1,b+1的节点
        ListNode a_pre=list1,b_next=list1;
        sentry.next=list1;
        ListNode pre=sentry;
        int count=0;
        while(list1!=null){
            if(count==a){
                a_pre=pre;
            }
            if(count==b){
                b_next=list1.next;
                break;
            }
            pre=pre.next;
            list1=list1.next;
            count++;
        }
        //链表进行连接
        a_pre.next=list2;
        list2rear.next=b_next;

        return sentry.next;
    }
}