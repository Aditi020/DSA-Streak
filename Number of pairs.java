// Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of) where x is an element from arr and y is an element from brr.
// Examples :
// Input: arr[] = [2, 1, 6], brr[] = [1, 5]
// Output: 3
// Explanation: The pairs which follow xy > yx are: 2^1 > 1^2,  2^5 > 5^2 and 6^1 > 1^6 .
// Input: arr[] = [2 3 4 5], brr[] = [1 2 3]
// Output: 5
// Explanation: The pairs which follow xy > yx are: 2^1 > 1^2 , 3^1 > 1^3 , 3^2 > 2^3 , 4^1 > 1^4 , 5^1 > 1^5 


import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

class Solution {
    public long countPairs(int[] arr, int[] brr, int M, int N) {
        int[] NoOfY = new int[5];
        for (int i = 0; i < N; i++) {
            if (brr[i] < 5) NoOfY[brr[i]]++;
        }
        Arrays.sort(brr);
        long total_pairs = 0;

        for (int x : arr) {
            if (x == 0) continue;
            if (x == 1) {
                total_pairs += NoOfY[0];
                continue;
            }

            int idx = Arrays.binarySearch(brr, x);
            if (idx < 0) idx = -idx - 1;
            else while (idx < N && brr[idx] == x) idx++;
            
            long count = N - idx;
            count += (NoOfY[0] + NoOfY[1]);

            if (x == 2) count -= (NoOfY[3] + NoOfY[4]);
            if (x == 3) count += NoOfY[2];

            total_pairs += count;
        }

        return total_pairs;
    }
}
