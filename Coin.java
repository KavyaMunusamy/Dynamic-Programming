import java.util.*;

class Coin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] coins = {1, 2, 3};
        int sum = 4;

        int cnt = count(coins, sum);

        System.out.println("The possible no of ways: " + cnt);
    }

    private static int count(int[] coins, int sum) {

        int n = coins.length;

        // DP table
        int[][] dp = new int[n + 1][sum + 1];

        // Base case:
        // There is 1 way to make sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= sum; j++) {

                // Exclude current coin
                dp[i][j] = dp[i - 1][j];

                // Include current coin
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}