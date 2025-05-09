// Given a number k and string s of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of s at most k times.

// Examples :
// Input: s = "1234567", k = 4
// Output: 7654321

// Input: s = "3435335", k = 3
// Output: 5543333

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    String ans;
    void r(char[] a, int k, int i) {
        if (k == 0 || i == a.length) return;
        char m = a[i];
        for (int j = i + 1; j < a.length; j++) if (a[j] > m) m = a[j];
        if (m != a[i]) {
            for (int j = a.length - 1; j >= i; j--) if (a[j] == m) {
                char t = a[i]; a[i] = a[j]; a[j] = t;
                String cur = new String(a);
                if (cur.compareTo(ans) > 0) ans = cur;
                r(a, k - 1, i + 1);
                a[j] = a[i]; a[i] = t;
            }
        } else r(a, k, i + 1);
    }
    public String findMaximumNum(String s, int k) {
        ans = s;
        r(s.toCharArray(), k, 0);
        return ans;
    }
}
