// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:
// Input: nums = [1,1]
// Output: [2]

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
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
                res.add(j + 1);  // Missing numbers
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

