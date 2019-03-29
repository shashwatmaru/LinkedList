/*
Insert into a Cyclic Sorted List

Given a node from a cyclic linked list which is sorted in ascending order,
write a function to insert a value into the list such that it remains a cyclic sorted list.
The given node can be a reference to any single node in the list,
and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion,
you may choose any place to insert the new value. After the insertion,
the cyclic list should remain sorted.

If the list is empty (i.e., given node is null),
you should create a new single cyclic list and return the reference to that single node.
Otherwise, you should return the original given node.

The following example may help you understand the problem better:
In the figure above, there is a cyclic sorted list of three elements.
You are given a reference to the node with value 3, and we need to insert 2 into the list.

The new node should insert between node 1 and node 3.
After the insertion, the list should look like this, and we should still return node 3.
 */





public class AddNodeInASortedCyclicLinkedList {


// Definition for a Node.
    static class Node {
        public int val;
        public Node next;
        public Node(){}

        public Node(int _val,Node _next) {
          val = _val;
            next = _next;
         }
    }

    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node temp = head;

        while(true){
            if(temp.val < temp.next.val){
                if((insertVal >= temp.val && insertVal <= temp.next.val)){
                    Node addNode = new Node(insertVal, temp.next);
                    temp.next = addNode;
                    break;
                }
            }
            else if(temp.val > temp.next.val){
                if((insertVal >= temp.val || insertVal <= temp.next.val)){
                    Node addNode = new Node(insertVal, temp.next);
                    temp.next = addNode;
                    break;
                }
            }
            else{
                if(temp.next == head){
                    Node addNode = new Node(insertVal, temp.next);
                    temp.next = addNode;
                    break;
                }
            }

            temp = temp.next;
        }
        return head;
    }

        public static void main(String [] agrs){

            Node head = new Node();
            Node node3 = new Node();
            node3.val = 3;
            Node node4 = new Node();
            node4.val = 4;
            node3.next = node4;
            head = node3;
            Node node1 = new Node();
            node1.val = 1;
            node1.next = node3;
            node4.next = node1;

        AddNodeInASortedCyclicLinkedList add = new AddNodeInASortedCyclicLinkedList();
          Node head1 =  add.insert(head, 2);
          System.out.print(head1.val+"->"+head1.next.val+"->"+head1.next.next.val+"->"+head1.next.next.next.val);

        }
}
