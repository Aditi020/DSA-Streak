// Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.
// Floor value of any number is the greatest Integer which is less than or equal to that number
// Examples:
// Input: n = 5
// Output: 2
// Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
// Input: n = 4
// Output: 2
// Explanation: Since, 4 is a perfect square, so its square root is 2.

import java.util.Scanner;
class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }

class Solution {
    long floorSqrt(long n) {
        long start = 1, end = n, ans = 0;
        for (; start <= end; ) {
            long mid = (start + end) / 2;

            if (mid * mid == n)
                return mid;
            else if (mid * mid < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
