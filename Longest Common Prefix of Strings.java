// Longest Common Prefix of Strings
// Difficulty: EasyAccuracy: 29.52%Submissions: 261K+Points: 2
// Given an array of strings arr. Return the longest common prefix among all strings present in the array. If there's no prefix common in all the strings, return "-1".
// Examples :
// Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
// Output: gee
// Explanation: "gee" is the longest common prefix in all the given strings.
// Input: arr[] = ["hello", "world"]
// Output: -1
// Explanation: There's no common prefix in the given strings.


import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
      if (arr == null || arr.length == 0) {
            return "-1";
        }
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int i = 0;
        for (; i < first.length() && i < last.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
        }
        String commonPrefix = first.substring(0, i);
        return commonPrefix.isEmpty() ? "-1" : commonPrefix;
    }
}
