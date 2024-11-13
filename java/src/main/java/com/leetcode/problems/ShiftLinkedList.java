public class ShiftLinkedList {
    public static void main(String[] args) {
        ShiftLinkedList sol=new ShiftLinkedList();
        // sol.shiftLinkedList(head, k);
    }

    public ListNode shiftLinkedList(ListNode head, int k) {
        int len = length(head);
        int r = Math.floorMod(k,len);
        if (r == 0)
            return head;

        ListNode first = head, second = head;

        while (r-- > 0)
            second = second.next;
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        // shift
        ListNode newH = first.next;
        first.next = null;
        second.next = head;
        return newH;
    }

    private int length(ListNode h) {
        int len = 0;
        while (h != null) {
            h = h.next;
            len++;
        }
        return len;
    }
}
