import java.util.HashMap;

class DeleteBst {
    public static void main(String[] args) {
        DeleteBst obj = new DeleteBst();
        String[] qt = new String[] { "addToKey", "addToKey", "insert", "addToValue", "addToValue", "get", "addToKey",
                "insert", "addToKey", "addToValue" };
        int[][] q = new int[][] { { -3 }, { -1 }, { 0, -3 }, { 3 }, { -1 }, { 0 }, { -1 }, { -4, -5 }, { -1 }, { -4 } };
        obj.hashMap(qt, q);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int shift = 0;

    long hashMap(String[] qt, int[][] q) {
        long res = 0;
        for (int i = 0; i < qt.length; i++) {
            switch (qt[i]) {
                case "insert":
                    insert(q[i][0], q[i][1]);
                    break;
                case "get":
                    res += get(q[i][0]);
                    break;
                case "addToKey":
                    addToKey(q[i][0]);
                    break;
                case "addToValue":
                    addToValue(q[i][0]);
                    break;
            }
        }
        return res;
    }

    void insert(int k, int v) {
        map.put(k, v);
    }

    long get(int k) {
        int key = k - shift;
        return map.getOrDefault(key, 0);
    }

    void addToKey(int k) {
        if (map.size() == 0)
            return;
        shift += k;
    }

    void addToValue(int v) {
        for (int k : map.keySet()) {
            map.put(k, map.get(k) + v);
        }
    }

}