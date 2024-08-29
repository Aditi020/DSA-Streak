// The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
// Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].
// Examples:
// Input: 1
// Output: [1]
// Explaination: Only one queen can be placed in the single cell available.
// Input: 4
// Output: [[2 4 1 3 ],[3 1 4 2 ]]
// Explaination: These are the 2 possible solutions.

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    private void solve(int n, int row, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            // Found a valid solution, add it to the result
            result.add(new ArrayList<>(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board.add(col + 1); // Place the queen
                solve(n, row + 1, board, result); // Recur for the next row
                board.remove(board.size() - 1); // Backtrack
            }
        }
    }
    
    private boolean isSafe(ArrayList<Integer> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int placedCol = board.get(i) - 1;
            // Check if any queen is placed in the same column or diagonals
            if (placedCol == col || Math.abs(placedCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(n, 0, new ArrayList<>(), result);
        return result;
    }
}
