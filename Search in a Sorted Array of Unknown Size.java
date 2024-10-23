// Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
// You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
// Example 1:
// Input: array = [-1,0,3,5,9,12], target = 9
// Output: 4
// Example 2:
// Input: array = [-1,0,3,5,9,12], target = 2
// Output: -1

import java.util.Arrays;
import java.math.*;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12, 14, 36, 58, 79, 90};
        System.out.println(range(arr, 79));  // Should print the index of 79
    }

    public static int range(int[] nums, int target) {
        int start = 0, end = 1;

        // Expand the search range exponentially until the target is within range
        while (true) {
            try {
                if (target <= nums[end]) break; // Target within range, stop expanding
            } catch (ArrayIndexOutOfBoundsException e) {
                end--; // Adjust 'end' to the last valid index
                break;
            }

            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        // Perform binary search within the identified range
        return BS(nums, target, start, end);
    }

    // Binary Search function within a specific range
    public static int BS(int[] nums, int target, int start, int end) {
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Target not found
     }
    }
