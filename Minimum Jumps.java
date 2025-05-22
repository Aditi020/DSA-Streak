// Given an array arr[] of non-negative integers, where each element represents the maximum length of the jumps that can be made forward from that element, find the minimum number of jumps to reach the end of the array starting from the first element.
// If an element is 0, then you cannot move through that element.
// Return -1 if you can't reach the end of the array.
// Example:
// Input:
// arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output:
// 3

class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;

                steps = maxReach - i;
            }
        }

        return -1;
    }
}
