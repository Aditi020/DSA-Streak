// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0. A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters. For example, "ace" is a subsequence of "abcde". A common subsequence of two strings is a subsequence that is common to both strings.
// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
                int m = text1.length();
        int n = text2.length();
        
        // Create a 2D dp array with (m+1) x (n+1) size
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The answer is the value in the bottom-right cell of the matrix
        return dp[m][n];
    }
}
