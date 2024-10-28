// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself). Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
// Example 1:
// Input: s = "level"
// Output: "l"
// Example 2:
// Input: s = "ababab"
// Output: "abab"

class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0; // Length of the previous longest prefix suffix

        // Build the lps array
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1]; // Move back in the prefix
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
            }
        }

        // The length of the longest happy prefix is lps[n - 1]
        int length = lps[n - 1];
        return s.substring(0, length);
    }
}
