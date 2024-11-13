public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(val).append("->").append(next).toString();
    }
}
