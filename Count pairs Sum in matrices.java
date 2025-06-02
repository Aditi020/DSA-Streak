// Given two matrices mat1[][] and mat2[][] of size n x n, where elements in each matrix are arranged in strictly ascending order (each row is sorted, and the last element of a row is smaller than the first element of the next row). You are given a target value x. Count all pairs {a, b} such that a is from mat1 and b is from mat2, and a + b = x.
// Example 1
// Input:
// n = 3, x = 21
// mat1 = [
//   [1,  5,  6],
//   [8, 10, 11],
//   [15,16, 18]
// ]
// mat2 = [
//   [2,  4,  7],
//   [9, 10, 12],
//   [13,16, 20]
// ]
// Output: 4
// Example 2
// Input:
// n = 2, x = 10
// mat1 = [
//   [1, 2],
//   [3, 4]
// ]
// mat2 = [
//   [4, 5],
//   [6, 7]
// ]
// Output: 2

class Solution {
    int countPairs(int[][] a, int[][] b, int x) {
        int r1 = 0, c1 = 0, r2 = b.length - 1, c2 = b[0].length - 1, cnt = 0;
        while (r1 < a.length && r2 >= 0) {
            int sum = a[r1][c1] + b[r2][c2];
            if (sum == x) { cnt++; c1++; c2--; }
            else if (sum < x) c1++;
            else c2--;
            if (c1 == a[0].length) { c1 = 0; r1++; }
            if (c2 < 0) { c2 = b[0].length - 1; r2--; }
        }
        return cnt;
    }
}
