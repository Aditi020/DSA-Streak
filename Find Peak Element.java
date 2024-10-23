// A peak element is an element that is strictly greater than its neighbors. Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Example 2:
// Input: nums = [1,2,1,3,5,6,4]
// Output: 5

class Solution {
    public int findPeakElement(int[] nums) {
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
        return start;  
    }
}
