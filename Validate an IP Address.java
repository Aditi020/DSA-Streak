You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1
A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)
Examples :
Input: str = 222.111.111.111
Output: true
Explanation: Here, the IPv4 address is as per the criteria mentioned and also all four decimal numbers lies in the mentioned range.
Input: str = 5555..555
Output: false
Explanation: 5555..555 is not a valid. IPv4 address, as the middle two portions are missing.m

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
class Solution {

    public boolean isValid(String str) {
        int n = str.length();
        int segments = 0;
        int num = 0;
        int length = 0;

        for (int i = 0; i < n; ++i) {
            if (str.charAt(i) == '.') {
                if (length == 0 || length > 3 || num > 255)
                    return false;
                segments++;
                num = 0;
                length = 0;
            } else if (Character.isDigit(str.charAt(i))) {
                if (length == 0 && str.charAt(i) == '0' && (i + 1 < n && str.charAt(i + 1) != '.'))
                    return false;
                num = num * 10 + (str.charAt(i) - '0');
                length++;
            } else {
                return false;
            }
        }

        if (length == 0 || length > 3 || num > 255)
            return false;
        segments++;

        return segments == 4;
    }
}
