// You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.
// Examples:
// Input: str1 = "ABCDGH", str2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring is "CDGH" which has length 4.
// Input: str1 = "ABC", str2 = "ACB"
// Output: 1
// Explanation: The longest common substrings are "A", "B", "C" all having length 1.

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int len1 = str1.length();
        int len2 = str2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLength = 0;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
