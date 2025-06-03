// Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings (not necessarily distinct) that have exactly k distinct characters.
// Example 1
// Input: s = "abc", k = 2
// Output: 2
// Example 2
// Input: s = "aba", k = 2
// Output: 3
// Example 3
// Input: s = "aa", k = 1
// Output: 3

class Solution {
    int count(String s, int k) {
        int[] freq = new int[26];
        int i = 0, ans = 0, distinct = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (++freq[s.charAt(j) - 'a'] == 1) ++distinct;
            while (distinct > k)
                if (--freq[s.charAt(i++) - 'a'] == 0) --distinct;
            ans += j - i + 1;
        }
        return ans;
    }

    int countSubstr(String s, int k) {
        return count(s, k) - count(s, k - 1);
    }
}
