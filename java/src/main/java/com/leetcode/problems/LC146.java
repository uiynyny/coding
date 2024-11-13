import java.util.HashMap;

public class LC146 {
    public static void main(String[] args) {
        LC146 lc=new LC146();
        LRUCache sol=lc.new LRUCache(2);
        sol.put(1, 1);
        sol.put(2, 2);
        int i = sol.get(1);
        System.out.println(i);
    }

    /**
     * LRUCache
     */
    public class LRUCache {

        class DLNode {
            int key;
            int value;
            DLNode prev;
            DLNode next;
        }

        private void addNode(DLNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        private DLNode pop() {
            DLNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private DLNode head;
        private DLNode tail;
        private int capacity;
        private int count;
        private HashMap<Integer, DLNode> hash;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            hash = new HashMap<>();

            this.head = new DLNode();
            head.prev = null;
            this.tail = new DLNode();
            tail.next = null;
            head.next=tail;
            tail.prev=head;
        }

        public int get(int key) {
            if (hash.containsKey(key)) {
                DLNode node = hash.get(key);
                this.moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hash.containsKey(key)) {
                DLNode node = hash.get(key);
                node.value = value;
                this.moveToHead(node);
            } else {
                DLNode node = new DLNode();
                node.key = key;
                node.value = value;
                this.hash.put(key, node);
                this.addNode(node);
                this.count++;
                if (count > capacity) {
                    DLNode pop = this.pop();
                    this.hash.remove(pop.key);
                    count--;
                }
            }
        }
    }
}
