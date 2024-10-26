// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number. You are given an integer array nums representing the data status of this set after the error. Find the number that occurs twice and the number that is missing and return them in the form of an array.
// Example 1:
// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:
// Input: nums = [1,1]
// Output: [1,2]

class Solution {
    public int[] findErrorNums(int[] arr) {
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

        int duplicate = -1;
        int missing = -1;

        // Collect the duplicate and missing numbers
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                duplicate = arr[j]; // The number which is out of place is the duplicate
                missing = j + 1;    // The expected number at this index
                break; // We can break since we only need one duplicate
            }
        }

        // Return the result as an array
        return new int[]{duplicate, missing};
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
