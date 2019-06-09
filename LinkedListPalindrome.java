public class LinkedListPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {
        }
    }

    private boolean isPalindrome(ListNode node1) {
        ListNode fast= node1;
        ListNode slow=node1;
        ListNode secondStart;
        while(true){
            fast = fast.next.next;
            if(fast == null){
                secondStart= slow.next;
                break;
            }
            if(fast.next == null) {
                secondStart = slow.next.next;
                break;
            }
            slow = slow.next;
        }
        slow.next=null;

        ListNode reverseListNode = reverseSecondList(secondStart);
        return compareLists(node1,reverseListNode);

    }

    private boolean compareLists(ListNode node1, ListNode reverseListNode) {
        while(node1 != null){
            if(node1.val != reverseListNode.val) return  false;
            node1=node1.next;
            reverseListNode=reverseListNode.next;
        }
        return  true;
    }

    private ListNode reverseSecondList(ListNode secondStart) {
        if(secondStart == null) return null;

        ListNode prev=secondStart;
        ListNode next = secondStart.next;
        if(next == null)
            return  secondStart;

        next = reverseSecondList(next);
        prev.next.next = prev;
        prev.next=null;
        return next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        node1.next = new ListNode();
        node1.next.val = 2;
        node1.next.next = new ListNode();
        node1.next.next.val = 2;
        node1.next.next.next = new ListNode();
        node1.next.next.next.val = 1;
        LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
        System.out.println("1. Given LinkedList is palindrome: "+linkedListPalindrome.isPalindrome(node1));


        ListNode node2 = new ListNode();
        node2.val = 1;
        node2.next = new ListNode();
        node2.next.val = 2;
        node2.next.next = new ListNode();
        node2.next.next.val = 3;
        node2.next.next.next = new ListNode();
        node2.next.next.next.val = 2;
        node2.next.next.next.next = new ListNode();
        node2.next.next.next.next.val = 1;
        System.out.println("2. Given LinkedList is palindrome: "+linkedListPalindrome.isPalindrome(node2));


    }

}