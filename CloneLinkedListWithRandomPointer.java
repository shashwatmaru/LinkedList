import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {
    public static class ListNode{
        int val;
        ListNode random;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode copyRandomList(ListNode head){
        ListNode clonedNodes;

        ListNode curr = head;
        ListNode next;
        while(curr != null){
            ListNode clone = new ListNode(curr.val);
            next = curr.next;
            curr.next=clone;
            clone.next=next;
            curr = next;
        }

        curr = head;
        while(curr != null){
            if(curr.random!= null){
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }

        curr = head;
        ListNode dummy= new ListNode(0);
        clonedNodes = dummy;
        ListNode copy;
        while(curr != null){
            next = curr.next.next;
            copy = curr.next;
            clonedNodes.next=copy;
            clonedNodes=copy;
            curr.next = next;
            curr = next;
        }
        return  dummy.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode();
        node1.val=1;
        node1.next = new ListNode();
        node1.next.val = 3;
        node1.next.next = new ListNode();
        node1.next.next.val = 2;
        node1.next.next.next = new ListNode();
        node1.next.next.next.val=5;
        node1.random = node1.next.next;
        node1.next.random = node1.next.next.next;
        node1.next.next.random = node1.next;
        node1.next.next.next.random = node1;

        CloneLinkedListWithRandomPointer cloneLinkedListWithRandomPointer = new CloneLinkedListWithRandomPointer();
        ListNode clonedNode = cloneLinkedListWithRandomPointer.copyRandomList(node1);
        while(clonedNode != null){
            System.out.println("VALUE: "+clonedNode.val+" RANDOM: "+clonedNode.random.val);
            clonedNode = clonedNode.next;
        }

    }


}
