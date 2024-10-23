// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease. Return the index of the peak element. Your task is to solve it in O(log(n)) time complexity.
// Example 1:
// Input: arr = [0,1,0]
// Output: 1
// Example 2:
// Input: arr = [0,2,1,0]
// Output: 1
// Example 3:
// Input: arr = [0,10,5,2]
// Output: 1

import java.util.Arrays;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        int[] arr = {0,2,3,10,15, 2};
        System.out.println(BS(arr));  // Should print the index of 79
    }

    // Binary Search function within a specific range
    public static int BS(int[] nums) {
        int start=0,end= nums.length-1;
        while (start < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] >nums[mid+1]) {
                end = mid;
            }
            else {
                start=mid+1;
            }
        }
        return nums[start];  
      // or  return start;  for index
     }
    }
