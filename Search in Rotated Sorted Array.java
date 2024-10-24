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
              int pivot=Pivot(nums);

        if (pivot == -1) {
            
            return BS(nums, target, 0 , nums.length - 1);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return BS(nums, target, 0, pivot - 1);
        }

        return BS(nums, target, pivot + 1, nums.length - 1);

    }
        public static int Pivot(int[] arr) {
         int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Binary Search function within a specific range in ascending order
    public static int BS(int[] arr, int target, int start, int end) {
         while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
}
}
