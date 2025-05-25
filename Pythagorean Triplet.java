// Given an integer array arr[], determine if there exists a triplet (a, b, c) in the array such that they satisfy the Pythagorean condition:
// a^2+b^2=c^2
// where a, b, and c are elements at different indices of the array.

// 📘 Examples
// Example 1:
// Input:
// arr = [3, 2, 4, 6, 5]
// Output:
// true
// Example 2:
// Input:
// arr = [3, 8, 5]
// Output:
// false

class Solution {
    public boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> squares = new HashSet<>();
        for (int x : arr) squares.add(x * x);
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (squares.contains(arr[i]*arr[i] + arr[j]*arr[j])) return true;
        return false;
    }
}
