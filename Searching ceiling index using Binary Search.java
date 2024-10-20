// You are given a sorted array of integers in ascending order. Write a function to find the ceiling of a target number in the array.

// Example 1:
// Input: 
// arr = [2, 4, 5, 7, 9, 12, 34, 67, 89, 90]
// target = 45
// Output: 
//67
      
// Example 2:
// Input: 
//arr = [2, 4, 5, 7, 9, 12, 34, 67, 89, 90]
//target = 90
// Output: 
//90

import java.util.Arrays;
import java.math.*;
class Solution {
    public static void main(String args[]){
        int[] arr={2,4,5,7,9,12,34,67,89,90};
        System.out.println(ceilofnum(arr, 4));
    }

    public static int ceilofnum(int[] nums,int target) {
        int a=-1, start=0,end=nums.length-1;

        if (target > nums[end]) {
            return -1;
        }
while (start<=end) {
    int mid=start+(end-start)/2;
    if (nums[mid] == target)
        return nums[mid];

    else if (nums[mid] < target) {
        // If mid element is smaller, search in the right half
        start = mid + 1;
    } else {
        // If mid element is greater, it could be the ceiling
        a = nums[mid];
        // Narrow the search to the left half
        end = mid - 1;
    }

} return a;
}
