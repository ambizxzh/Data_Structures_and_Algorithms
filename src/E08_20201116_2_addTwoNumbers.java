package E08_20201116_2_addTwoNumbers;

public class E08_20201116_2_addTwoNumbers {
    //E08 2.使用链表模拟加法运算(两数相加) 问题来源:https://leetcode-cn.com/problems/add-two-numbers/
    public static void main(String[] args){
        int[] array1= {9, 9, 9, 9, 9, 9, 9};//{2, 4, 3};
        int[] array2= {9, 9, 9, 9};//{5, 6, 4};

        //利用哨兵进行初始化
        ListNode sentry=new ListNode(-1);
        ListNode pre=sentry;
        for(int arr:array1){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode l1 = sentry.next;

        pre=sentry;
        for(int arr:array2){
            pre.next=new ListNode(arr);
            pre=pre.next;
        }
        ListNode l2=sentry.next;
        Solution solution=new Solution();
        ListNode result = solution.addTwoNumbers(l1,l2);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentry=new ListNode(-1);//使用哨兵
        ListNode sum_result=sentry;
        sentry.next=sum_result;
        int flag=0;
        int sum=0;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){sum=l1.val + l2.val + flag;l1=l1.next;l2=l2.next;}
            else if(l1!=null){sum=l1.val+flag;l1=l1.next;}
            else{sum=l2.val+flag;l2=l2.next;}

            sum_result.next=new ListNode(sum%10);
            flag=sum/10;
            sum_result=sum_result.next;


        }
        if(flag!=0){
            sum_result.next=new ListNode(flag);
        }
        return sentry.next;
    }
}
