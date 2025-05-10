// Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.
// Examples:
// Input: arr[] = [1, 2, 3, 4, 1], k = 2
// Output: 3

// Input: arr[] = [6, 5, 3, 4], k = 2
// Output: 4

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> firstIdx = new HashMap<>();
        int s = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] > k ? 1 : -1;
            if (s > 0) {
                res = i + 1;
            } else {
                firstIdx.putIfAbsent(s, i);
                if (firstIdx.containsKey(s - 1)) {
                    res = Math.max(res, i - firstIdx.get(s - 1));
                }
            }
        }
        return res;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
