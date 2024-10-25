// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order. The first integer of each row is greater than the last integer of the previous row. 
// Given an integer target, return true if target is in matrix or false otherwise.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        int[][] arr =
        {{1 ,3 ,5 ,7},
        {10,11,16,20},
        {23,30,34,60}};
        System.out.println(Arrays.toString(search(arr, 60)));  // Should print the index of 79
    }

    static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[r].length-1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}
