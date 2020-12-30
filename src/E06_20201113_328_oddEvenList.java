package E06_20201113_328_oddEvenList;

public class E06_20201113_328_oddEvenList {
    //E06 328.奇偶链表  问题来源:https://leetcode-cn.com/problems/odd-even-linked-list/
    public static void main(String[] args){
        int[] list_array={1,2,3,4,5};
        ListNode head=null;
        ListNode currentNode=null;
        for(int arr:list_array){
            if(head==null){
                head=new ListNode(arr);
                currentNode=head;
            }else{
                currentNode.next=new ListNode(arr);//生成一个新节点
                currentNode=currentNode.next;//将新节点加到原链表的尾部
            }
        }

        Solution solution= new Solution();
        ListNode list=solution.oddEvenList(head);
        while (list!=null){
            System.out.print(list.val);
            list=list.next;
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }

        return swapList(head);
    }

    //交换节点(方法灵感来自于快慢指针法求中间节点,fast的起始和迭代都修改成上一节点的next就行，这里慢指针slow可以替换成odd奇节点,快指针fast可以替换为even偶节点)
    //该方法也被成为奇偶指针法:奇偶指针与节点交换
    private ListNode swapList(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;//   若是快慢指针,则起始为fast=head.next.next;
        while(fast!=null && fast.next!=null){
            //从原链表中提取出待插入的数据点
            ListNode temporaryNode=fast.next;//第一步:提取，使用临时变量保存待插入数据点
            fast.next=temporaryNode.next;//第二步:将待插入数据点的后继成为待插入数据点前驱的后继，即删除待插入数据点(是从原链表中删除,临时变量里的还在)

            //进行插入操作
            temporaryNode.next=slow.next;//第三步:待插入位置的后继节点 成为 待插入数据的点的后继。插入
            slow.next=temporaryNode;//第四步:接入

            slow=slow.next;
            fast=fast.next;//   若是快慢指针，则迭代为fast=fast.next.next;
        }
        return head;
    }
}
