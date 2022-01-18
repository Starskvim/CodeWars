package kyu5;


public class SwapNodePairsInLinkedList {

    public static void main(String[] args) {


        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        System.out.println(node1.printList());

        swapPairs(node1);

        System.out.println(node6.printList());

    }

    public static Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node cur = head;
        Node newHead = head.next;
        while (cur != null && cur.next != null) {
            Node mem = cur;
            cur = cur.next;

            mem.next = cur.next;
            cur.next = mem;

            cur = mem.next;
            if (cur != null && cur.next != null) {
                mem.next = cur.next;
            }
        }
        return newHead;
    }
    public static class Node {
        private String value;
        public Node next;

        public Node(String value) { this.value = value; }

        public String getValue() { return value; }

        public String toString() { return this.value; }

        public String printList() {
            if (this.next == null) return this.toString() + " ->";
            return this.toString() + " -> " + next.printList();
        }
    }

    //recursive var
    public  static Node swapPairsRec (Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pos1 = head;
        Node pos2 = head.next;
        Node pos3 = pos2.next;
        pos1.next = pos3;
        pos2.next = pos1;
        if (pos3 != null){
            pos1.next = swapPairs(pos3);
        }
        return pos2;

    }

}
