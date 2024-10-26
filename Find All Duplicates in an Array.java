// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice. You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output.
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]
// Example 2:
// Input: nums = [1,1,2]
// Output: [1]
// Example 3:
// Input: nums = [1]
// Output: []


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> missingNumbers = sort(arr);
        System.out.println(Arrays.toString(arr));  // To view the sorted array
        System.out.println(missingNumbers);        // Print missing numbers
    }

    static List<Integer> sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;  // Expected position for current element

            // Only swap if the current element is not at the correct position,
            // and the target position doesn't already have the correct value
            if (arr[i] != arr[correct] && arr[i] <= arr.length) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // Collect all the missing numbers
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                 res.add(arr[j]);  // Missing numbers
            }
        }
        return res;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
