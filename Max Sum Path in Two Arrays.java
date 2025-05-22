// Problem Description
// Given two sorted arrays of distinct integers, arr1 and arr2, each containing some common elements, find the maximum sum of a path from the beginning of any array to the end of any array. You can switch from one array to the other only at the common elements. The common element should be considered only once in the result when switching.
// Examples:
// Input:
// arr1 = [2, 3, 7, 10, 12]
// arr2 = [1, 5, 7, 8]
// Output:
// 35


class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int i = 0, j = 0;
        int result = 0, sum1 = 0, sum2 = 0;
        int m = arr1.size(), n = arr2.size();

        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i++);
            } else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j++);
            } else {
                result += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < m) sum1 += arr1.get(i++);
        while (j < n) sum2 += arr2.get(j++);

        result += Math.max(sum1, sum2);

        return result;
    }
}
