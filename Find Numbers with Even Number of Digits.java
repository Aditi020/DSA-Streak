// Given an array nums of integers, return how many of them contain an even number of digits.
// Example 1:
// Input: nums = [12,345,2,6,7896]
// Output: 2

// Example 2:
// Input: nums = [555,901,482,1771]
// Output: 1 

import java.util.Arrays;
import java.math.*;
class Solution {
    public static void main(String args[]){
        int[] arr={12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }

    public static int findNumbers(int[] nums) {
        int a=0, d=0;
        for(int i:nums){
            d=(int)Math.floor(Math.log10(i))+1;
            if (d%2==0)
                a++;
        }
        return a;
    }
}
