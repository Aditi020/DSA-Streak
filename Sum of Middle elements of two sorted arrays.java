// Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.
// Examples:
// Input: arr1 = [1, 2, 4, 6, 10], arr2 = [4, 5, 6, 9, 12]
// Output: 11
// Explanation: The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12]. Sum of middle elements is 11 (5 + 6).
// Input: arr1 = [1, 12, 15, 26, 38], arr2 = [2, 13, 17, 30, 45]
// Output: 32
// Explanation: The merged array looks like [1, 2, 12, 13, 15, 17, 26, 30, 38, 45]. Sum of middle elements is 32 (15 + 17).

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int low = 0, high = n;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = n - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2) + Math.min(r1, r2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.sumOfMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}
