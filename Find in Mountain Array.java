// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// Example 1:
// Input: array = [1,2,3,4,5,3,1], target = 3
// Output: 2
// Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
// Example 2:
// Input: array = [0,1,2,4,2,1], target = 3
// Output: -1
// Explanation: 3 does not exist in the array, so we return -1.


 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
       int start=0,end= mountainArr.length()-1; int result=-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) == target) {
                result = mid;  // Store the index
                end = mid - 1;    // Keep searching the left half
            } else if (mountainArr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return result;   
    }
}


// or


// complete solution below 
// import java.util.Arrays;
// import java.math.*;

// class Solution {
//     public static void main(String[] args) {
//         int[] arr = {1,2,3,4,5,3,1};
//         System.out.println(BS(arr, 3));  // Should print the index of 79
//     }

//     // Binary Search function within a specific range
//     public static int BS(int[] nums, int target ) {
//         int start=0,end= nums.length-1; int result=-1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;

//             if (nums[mid] == target) {
//                 result = mid;  // Store the index
//                 end = mid - 1;    // Keep searching the left half
//             } else if (nums[mid] < target) {
//                 start = mid + 1;
//             } else {
//                 end = mid-1;
//             }
//         }
//         return result;
//      }
//     }



