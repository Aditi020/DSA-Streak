// Given two strings pattern and str which may be of different size, You have to return 1 if the wildcard pattern i.e. pattern, matches with str else return 0. All characters of the string str and pattern always belong to the Alphanumeric characters.
// The wildcard pattern can include the characters ? and *
// ‘?’ – matches any single character.
// ‘*’ – Matches any sequence of characters (including the empty sequence).
// Note: The matching should cover the entire str (not partial str).
// Examples:
// Input: pattern = "ba*a?", str = "baaabab"
// Output: 1
// Explanation: replace '*' with "aab" and 
// '?' with 'b'.
// Input: pattern = "a*ab", str = "baaabab"
// Output: 0
// Explanation: Because in string pattern character 'a' at first position,
// pattern and str can't be matched. 

//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    public int wildCard(String pattern, String str) {
        int m = str.length();
        int n = pattern.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int j = 1; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            int[] newDp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == str.charAt(i - 1)) {
                    newDp[j] = dp[j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    newDp[j] = dp[j] | newDp[j - 1];
                }
            }
            dp = newDp;
        }

        return dp[n];
    }
}
