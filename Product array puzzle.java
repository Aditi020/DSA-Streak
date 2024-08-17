// Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].
// Examples:
// Input: nums[] = [10, 3, 5, 6, 2]
// Output: [180, 600, 360, 300, 900]
// Explanation: For i=0, P[i] = 3*5*6*2 = 180.
// For i=1, P[i] = 10*5*6*2 = 600.
// For i=2, P[i] = 10*3*6*2 = 360.
// For i=3, P[i] = 10*3*5*2 = 300.
// For i=4, P[i] = 10*3*5*6 = 900.
// Input: nums[] = [12,0]
// Output: [0, 12]


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

class Solution {
    public long[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long[] leftProduct = new long[n];
        long[] result = new long[n];
        
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        long rightProductAcc = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = leftProduct[i] * rightProductAcc;
            rightProductAcc *= nums[i];
        }

        return result;
    }
}
