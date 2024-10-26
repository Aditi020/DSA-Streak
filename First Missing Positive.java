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

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
            int[] arr = {5, 4, 3, 2, 1};
            sort(arr);
            System.out.println(Arrays.toString(arr));
        }

        static void sort(int[] arr) {
            int i = 0;
            while (i < arr.length) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct])
                    swap(arr, i, correct);
                 else
                    i++;
            }
        }

        static void swap(int[] arr, int first, int second) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }

    }
