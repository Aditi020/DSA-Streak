// You must count every distinct sequence of face-up values (order matters).
// You are given:
// n dice,
// each having m faces numbered from 1 to m,
// and a target sum x.
// Find the number of ways to get the sum x using the n dice. The result can be large, so return it modulo 10⁹+7.
// Example 1:
// Input:
// m = 6, n = 3, x = 12
// Output:
// 25
// Explanation:
// There are 25 distinct sequences of three 6-faced dice that sum up to 12.
// Example 2:
// Input:
// m = 2, n = 3, x = 6
// Output:
// 1
// Explanation:
// Only the sequence [2,2,2] sums to 6 when using three 2-faced dice.

class Solution {
    static int noOfWays(int m, int n, int x) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][x + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= x; ++j)
                for (int k = 1; k <= m && k <= j; ++k)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
        return dp[n][x];
    }
}
