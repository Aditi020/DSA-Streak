// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// Example 1:
// Input: array = [1,2,3,4,5,3,1], target = 3
// Output: 2
// Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
// Example 2:
// Input: array = [0,1,2,4,2,1], target = 3
// Output: -1
// Explanation: 3 does not exist in the array, so we return -1.


 
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
   class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakElement(mountainArr);
        int res = BS(mountainArr, target, 0, peakIndex);
        if (res != -1) {
            return res;
        }
        return BS2(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
    }

    public static int findPeakElement(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int BS(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int BS2(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}


// or


//COMPLETE NORMAL SOLUTION 



import java.util.Arrays;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2};
        System.out.println(search(arr, 2));  // Should print the index of 79
    }

    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int search(int[] arr, int target) {
        int a = findPeakElement(arr);
        int res = 0;
            res = BS(arr, 2, a);

         if (res != -1) {
            return res; // Found in the left side
        }
        return BS2(arr, 2, a+1);

    }

    // Binary Search function within a specific range
    public static int BS(int[] nums, int target, int end) {
        int start=0;
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
        return -1; // Target not found
    }

    // Binary Search function for the right side (descending part)
    public static int BS2(int[] nums, int target, int start) {
        int end= nums.length-1;;
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid index

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                end = mid - 1; // Move to the left half (decrease end)
            } else {
                start = mid + 1; // Move to the right half (increase start)
            }
        }
        return -1;
    }
}
