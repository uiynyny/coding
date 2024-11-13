public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween solution = new ReverseBetween();
        int[] a = { 1, 2, 3, 4, 5 };
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i : a) {
            ListNode temp = new ListNode(i);
            head.next = temp;
            head = temp;
        }
        ListNode n = solution.reverseBetween(dummy.next, 4, 5);
        System.out.println(n);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n - m == 0)
            return head;
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            if (index == m) {
                // start to reverse
                ListNode rev = reverse(cur.next, n - m);
                cur.next = rev;
                return dummy.next;
            }
            cur = cur.next;
            index++;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode n, int len) {
        ListNode pre = null;
        ListNode cur = n;
        int index = 0;
        ListNode temp = null;
        while (cur != null && index <= len) {
            // get next iter head
            temp = cur.next;
            // relink to pre
            cur.next = pre;
            // move forward
            pre = cur;
            cur = temp;
            index++;
        }
        // temp is next and n is tail, cur is head
        n.next = temp;
        return pre;
    }

}
