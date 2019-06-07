public class ReverseALinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode reverseIterative(ListNode curr) {
        ListNode prev = curr;
        ListNode next = curr.next;
        curr.next = null;
        curr = next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

        System.out.println("Iterative method");
        ListNode clonedNode = ReverseALinkedList.reverseIterative(node1);
        while(clonedNode != null){
            System.out.println("VALUE: "+clonedNode.val);
            clonedNode = clonedNode.next;
        }

        System.out.println("Recursive method");
        ListNode node2 = new ListNode();
        node2.val=1;
        node2.next = new ListNode();
        node2.next.val = 3;
        node2.next.next = new ListNode();
        node2.next.next.val = 2;
        node2.next.next.next = new ListNode();
        node2.next.next.next.val=5;

        ListNode clonedNode1 = ReverseALinkedList.reverseRecursive(node2);
        while(clonedNode1 != null){
            System.out.println("VALUE: "+clonedNode1.val);
            clonedNode1 = clonedNode1.next;
        }
    }
    private static ListNode reverseRecursive(ListNode curr) {
        if(curr == null || curr.next == null) return curr;

        ListNode reverseNode = reverseRecursive(curr.next);
        curr.next.next= curr;
        curr.next = null;
        return  reverseNode;
    }


}


