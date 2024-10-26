// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums. You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
// Example 1:
// Input: nums = [1,2,0]
// Output: 3
// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2
// Example 3:
// Input: nums = [7,8,9,11,12]
// Output: 1

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] < 0) nums[i] = n+2;
            // else if(nums[i] >= n) nums[i] = n+1;
            else if(nums[i] == 0) nums[i] = n+3;
        }

        for(int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if(val > n) continue;

            if(nums[val-1] > 0) nums[val-1] *= -1;
        }

        int ans = 1;

        for(int i=0; i<n; i++) {
            if(nums[i] > 0) break;
            else ans++;
        }

        return ans;
    }
}
