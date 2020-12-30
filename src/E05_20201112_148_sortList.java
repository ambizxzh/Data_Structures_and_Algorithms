package E05_20201112_148_sortList;

public class E05_20201112_148_sortList {
    //E05 148.排序链表 问题来源:https://leetcode-cn.com/problems/sort-list/
    //题目要求O(n * log n)的时间复杂度和O(1)的空间复杂度,所以应该使用快排或者归并排序(两者的时间复杂度都是所要求的)

    //而归并排序和快速排序的问题在数组中的解决办法为:
    //归并排序的递推公式 merge_sort([p,...,r])=merge_function(merge_sort([p,...,q]),merge_sort([q+1,r]));
    // q=(p+r)/2;以上merger_sort是递归排序函数,merge_function是每个递归中的归并操作函数
    //归并排序递推公式的终止条件是:p>=r

    //快速排序的递推公式 quick_sort([p,...,r])=quick_sort([p,q-1])+quick_sort([q+1,r]);
    //快速排序递推公式的终止条件是:p>=r

    public static void main(String[] args){
        int[] array={4,1,2,3};//[4,2,1,3]

        //单链表的初始化
        ListNode head=null;
        ListNode current=null;
        for(int a:array){
            if(head == null){
                head=new ListNode(a);
                current=head;
            }else{
                current.next=new ListNode(a);
                current=current.next;
            }
        }

        Solution solution=new Solution();
        ListNode list=solution.sortList(head);
        while(list!=null){
            System.out.print(list.val);
            list=list.next;
        }

    }
}
/**
 * Definition for singly-linked list.
 * */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution{
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){//为空链表的情况,也是递归的终止条件
            return head;
        }

        //找到链表的中间节点并断开链表
        ListNode middleNode=findMiddleNode(head);
        ListNode rightHead=middleNode.next;//中间节点就是右链表的起始节点
        middleNode.next=null;//断开链表

        //递归下探
        ListNode left=sortList(head);//头节点就是左节点的起始节点。递归
        ListNode right=sortList(rightHead);//中间节点就是右链表的起始节点。递归

        return mergeTwoList(left, right);//在当前递归层面(当前业务层),合并有序链表 ,并返回
    }

    //快慢指针法找到单链表的中间节点(876. 链表的中间节点)
    private ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slowPoint=head;
        ListNode fastPoint=head.next.next;
        while(fastPoint!=null && fastPoint.next!=null){
            slowPoint=slowPoint.next;
            fastPoint=fastPoint.next.next;
        }
        return slowPoint;
    }

    //使用哨兵(sentry)法(即带有空节点的头节点)合并两个有序链表(21. 合并两个有序链表)
    private ListNode mergeTwoList(ListNode listNode1,ListNode listNode2){
        ListNode sentry=new ListNode(-1);//设置一个空节点作为头节点，这是哨兵法,以便在循环时的各步骤操作一致,方便代码编写
        ListNode current=sentry;
        while(listNode1 != null && listNode2 != null){
            if(listNode1.val < listNode2.val){
                current.next=listNode1;
                listNode1=listNode1.next;//与索引值自加一同效果,都是向后移动一位索引
            }else{
                current.next=listNode2;
                listNode2=listNode2.next;
            }
            current=current.next;
        }
        current.next= listNode1!=null ? listNode1 : listNode2;//以上while循环还会剩余某一个值没有合并过来,这里是对其的合并
        return sentry.next;
    }
}
