// Given an array of integers arr, return true if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays are equal. If it is not possible then return false.
// Examples:
// Input: arr = [1, 2, 3, 4, 5, 5]
// Output: true
// Explanation: In the above example, we can divide the array into two subarrays with eqaul sum. The two subarrays are: [1, 2, 3, 4] and [5, 5]. The sum of both the subarrays are 10. Hence, the answer is true.
// Input: arr = [4, 3, 2, 1]
// Output: false
// Explanation: In the above example, we cannot divide the array into two subarrays with eqaul sum. Hence, the answer is false.

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}


class Solution {
    public boolean canSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int rightSum = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            rightSum += arr[i];
            if (rightSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}
