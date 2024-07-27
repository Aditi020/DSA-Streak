// Given a string str without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.

// Note: The original order of characters must be kept the same. 

// Examples :

// Input: str = "zvvo"
// Output: "zvo"
// Explanation: Only keep the first occurrence
// Input: str = "gfg"
// Output: "gf"
// Explanation: Only keep the first occurrence

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
                boolean[] seen = new boolean[256]; // Assuming ASCII characters
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }

        return result.toString();
    }
}
