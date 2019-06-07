public class FindMidElementInLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        node1.next = new ListNode();
        node1.next.val = 3;
        node1.next.next = new ListNode();
        node1.next.next.val = 2;
        node1.next.next.next = new ListNode();
        node1.next.next.next.val = 5;
        FindMidElementInLinkedList findMidElementInLinkedList = new FindMidElementInLinkedList();
        System.out.println("Middle element is: "+ findMidElementInLinkedList.findMidElement(node1).val);
    }

    private ListNode findMidElement(ListNode node1) {
        ListNode slow= node1;
        ListNode fast= node1;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }
}
