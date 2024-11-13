/**
 * LC1335
 */
public class LC1335 {
    public static void main(String[] args) {
        int[] jd = new int[] { 6, 5, 4, 3, 2, 1 };
        LC1335 sol = new LC1335();
        int minDifficulty = sol.minDifficulty(jd, 2);
        System.out.println(minDifficulty);
    }

    public int minDifficulty(int[] jd, int d) {
        int N = jd.length;
        int[][] dp = new int[d][N];
        // first day difficulty
        dp[0][0] = jd[0];
        // max diff for day i
        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jd[i]);
        }

        // for 2.. days
        for (int day = 1; day < d; day++) {
            for (int job = day; job < N; job++) {
                // min diff of day with #jobs
                dp[day][job] = Integer.MAX_VALUE;
                // max set to start point
                int local_max = jd[job];
                // find min diff for dp[day][job]
                for (int schedule = job; schedule >= day; schedule--) {
                    local_max = Math.max(local_max, jd[schedule]);
                    dp[day][job] = Math.min(dp[day - 1][schedule - 1] + local_max, dp[day][job]);
                }
            }
        }
        return dp[d - 1][N - 1];
    }
}