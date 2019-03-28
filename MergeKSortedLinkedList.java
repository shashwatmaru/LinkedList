import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLinkedList {

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
      public ListNode mergeKLists(ListNode[] lists) {
          if(lists == null || lists.length ==0){
              return null;
          }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(ListNode linklist: lists){
                while(linklist != null){
                    minHeap.add(linklist.val);
                    linklist = linklist.next;
                }
            }

            ListNode result = new ListNode(-1);
            ListNode answer = result;

            while(!minHeap.isEmpty()){
                answer.next = new ListNode(minHeap.remove());
                answer = answer.next;
            }

            return result.next;
        }
        public static void main(String[] args){
          MergeKSortedLinkedList mergeKSortedLinkedList = new MergeKSortedLinkedList();

          ListNode linklist1 = new ListNode(1);
          linklist1.next = new ListNode(4);
          linklist1.next.next = new ListNode(5);

            ListNode linklist2 = new ListNode(1);
            linklist2.next = new ListNode(3);
            linklist2.next.next = new ListNode(4);

            ListNode linklist3 = new ListNode(2);
            linklist3.next = new ListNode(6);

            ListNode[] list = {linklist1,linklist2,linklist3};
            ListNode answer = mergeKSortedLinkedList.mergeKLists(list);
            while(answer != null){
                if(answer.next != null)
                    System.out.print(answer.val+"->");
                else
                    System.out.print(answer.val);
                answer = answer.next;
            }
        }
}
