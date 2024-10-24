// Given a **rotated sorted array** in ascending order with distinct values, write an algorithm that returns the **index of a target element** if it exists, or **-1 if it does not**. The rotation occurs at an unknown pivot, dividing the array into two sorted parts. Ensure the solution runs in **O(log n)** time.
//   Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:
// Input: nums = [1], target = 0
// Output: -1

class Solution {
    public int search(int[] nums, int target) {
        int a = Pivot(nums);
        int res = 0;
        res = BS(nums, target, 0, a-1);

        if (res != -1) {
            return res; // Found in the left side
        }
        return BS(nums, target, a, nums.length - 1);

    }
        public static int Pivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // Binary Search function within a specific range in ascending order
    public static int BS(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid index

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                start = mid + 1; // Move to the right half
            } else {
                end = mid - 1; // Move to the left half
            }
        }
        return -1;
    }
}
