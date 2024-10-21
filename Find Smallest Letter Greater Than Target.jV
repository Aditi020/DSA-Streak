// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
// Example 1:
// Input: letters = ["c","f","j"], target = "a"
// Output: "c"
// Example 2:
// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Example 3:
// Input: letters = ["x","x","y","y"], target = "z"
// Output: "x"

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
     int start = 0, end = letters.length - 1;

        if (target >= letters[end]) {
            return letters[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] > target) {
                // If mid element is smaller, search in the right half
                end = mid - 1;
            } else {
                // If mid element is greater, it could be the ceiling
                // Narrow the search to the left half
                start = mid + 1;
            }

        }
        return letters[start];
    }
}
