import java.util.LinkedList;
import java.util.Queue;

/**
 * DemolitionRobot
 */
public class DemolitionRobot {

    public static void main(String[] args) {
        DemolitionRobot sol = new DemolitionRobot();
        int[][] lot = { { 1, 1, 1 }, { 0, 0, 1 }, { 9, 0, 1 } };
        int res = sol.search(lot);
        System.out.println(res);
    }

    public int search(int[][] grid) {
        int step = 0;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] v = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        // q is non empty
        while (!q.isEmpty()) {
            int size = q.size();
            // for each step
            for (int i = 0; i < size; i++) {
                int[] origin = q.poll();
                v[origin[0]][origin[1]] = true;
                for (int[] d : dirs) {
                    int row = origin[0] + d[0];
                    int col = origin[1] + d[1];
                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0
                            || v[row][col]) {
                        continue;
                    }
                    if (grid[row][col] == 9) {
                        return step + 1;
                    }
                    q.offer(new int[] { row, col });
                }
            }
            step++;
        }
        return -1;
    }
}