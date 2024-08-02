// A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.  A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
// Note: Follow 0-based indexing.
// Examples:
// Input: mat[][] = [[0 1 0],
//                 [0 0 0], 
//                 [0 1 0]]
// Output: 1
// Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 
// Input: mat[][] = [[0 1],
//                 [1 0]]
// Output: -1
// Explanation: The two people at the party both know each other. None of them is a celebrity.

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (mat[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }
}
