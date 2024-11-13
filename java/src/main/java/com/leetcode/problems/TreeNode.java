public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(val).append("->").append(left).append(right).toString();
    }
}
