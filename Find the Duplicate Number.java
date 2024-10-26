// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive. There is only one repeated number in nums, return this repeated number. You must solve the problem without modifying the array nums and using only constant extra space.
// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:
// Input: nums = [3,3,3,3,3]
// Output: 3

class Solution {
    public int findDuplicate(int[] arr) {
            int i = 0 ;
            while (i < arr.length) {
                int correct = arr[i]-1 ;
                if (arr[i]< arr.length && arr[i] != arr[correct])
                    swap(arr, i, correct);
                 else
                    i++;
            }
            for (int j = 0; j < arr.length ; j++) {
                if(arr[j]!=j+1)
                    return arr[j];
            }
            return arr[arr.length]+1;
    }
    
        static void swap(int[] arr, int first, int second) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
}
