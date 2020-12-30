package E07_20201113_147_insertionSortList;

public class E07_20201113_147_insertionSortList {
    //E07  147.对链表进行插入排序 问题来源:https://leetcode-cn.com/problems/insertion-sort-list/
    public static void main(String[] args){
        int[] array={4,2,1,3};
        ListNode head=null;
        ListNode current=null;
        for(int arr:array){
            if(head==null){
                head=new ListNode(arr);
                current=head;
            }else{
                current.next=new ListNode(arr);
                current=current.next;
            }
        }
        Solution solution=new Solution();
        ListNode list=solution.insertionSortList(head);
        while(list!=null){
            System.out.print(list.val);
            list=list.next;
        }

    }
}
class ListNode {//链表类
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode insertionSortList(ListNode head) {
        //使用分割链表的方法，借助哨兵
        ListNode sentry=new ListNode(-1);//哨兵
        ListNode pre=sentry;//从哨兵开始的指针
        sentry.next=head;

        //初始化分割
        ListNode temporary=head.next;
        head.next=null;
        head=temporary;//使用head保存分割后面的那一部分
        while(head!=null){
            //哨兵始终指向最前面的空节点
            pre=sentry;
            //继续每个循环下的分割操作
            temporary=head.next;
            head.next=null;
            while(pre.next!=null && head.val > pre.next.val){//倘若,前段已经到结尾了,或者后段的值还是比前段的值大,则继续往后遍历,无需交换
                pre=pre.next;
            }
            //进行交换(带哨兵的链表的交换).在没有经过上一句的的循环时,pre指向的是头部的空节点
            head.next=pre.next;
            pre.next=head;

            //呼应前面的循环切割和初始化切割。
            head=temporary;
        }
        return sentry.next;
//        if(head==null||head.next==null){//链表为空或者链表只有一个元素
//            return head;
//        }
//
//        ListNode cutPoint=head;
//        while(cutPoint!=null && cutPoint.next!=null){
//            ListNode insertNodePoint=cutPoint.next;
//            cutPoint.next=null;
//            if(cutPoint==head){
//                if(cutPoint.val>insertNodePoint.val){
//                    ListNode temporary=insertNodePoint.next;//第一步:保护待删除点的后面的链表
////                    insertNodePoint.next=head;
////                    head.next=temporary;
//                    insertNodePoint.next=cutPoint;//第二步:插入位置的
//                    insertNodePoint.next.next=temporary;
//                    head=insertNodePoint;
//                }
//            }else{
//                ListNode slow=head,fast=head;
//                int flag=0;
//                while(fast!=null && fast.next!=null) {
//                    if(fast.val>insertNodePoint.val){
//                        ListNode temporary= insertNodePoint.next;//提取,保存需要插入的数据点的后面的数据
//                        insertNodePoint.next=fast;
////                        slow.next=insertNodePoint;
//                        cutPoint.next=temporary;
//                        break;
//                    }
//                    if(flag!=0){
//                        slow=slow.next;
//                    }
//                    flag=1;
//                    fast=fast.next;
//                }
//            }
////            cutPoint=cutPoint.next;
//        }
//        return head;
    }

}
