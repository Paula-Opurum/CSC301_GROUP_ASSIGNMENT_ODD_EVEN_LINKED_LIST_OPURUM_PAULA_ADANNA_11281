
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = next; }
}

class OddEven {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;

        ListNode current = head;
        int index = 1;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = null;

            if (index % 2 != 0) {

                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else {

                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }

            current = nextNode;
            index++;
        }


        oddTail.next = evenHead;

        return oddHead;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        head.next = new ListNode(5);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(15);
        head.next.next.next.next = new ListNode(6);

        OddEven solver = new OddEven();
        ListNode result = solver.oddEvenList(head);


        System.out.println("Reordered Odd-Even List:");
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}