// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. Given a string s, return true if it is a palindrome, or false otherwise.
// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Example 2:
// Input: s = "race a car"
// Output: false
// Example 3:
// Input: s = " "
// Output: true

class Solution {
    public boolean isPalindrome(String s) {
              String w = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(w).reverse();
        System.out.println(w);
        System.out.println(reversed);
        return w.equals(reversed.toString());
    }
}
