// You are given a string num consisting of only digits. A string of digits is called balanced if the sum of the digits at even indices is equal to the sum of digits at odd indices. Return true if num is balanced, otherwise return false.
// Example 1:
// Input: num = "1234"
// Output: false
// Example 2:
// Input: num = "24123"
// Output: true

import java.math.BigInteger;
class Solution {
    public boolean isBalanced(String num) {
        BigInteger n = new BigInteger(num);
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;
        for(BigInteger i=n;i.compareTo(BigInteger.ZERO) > 0; i = i.divide(BigInteger.TEN)) {
            BigInteger digit = i.mod(BigInteger.TEN);
            int j = i.toString().length() % 2 == 0 ? 1 : 0;
            if(j==1){
                a = a.add(digit);
            } else {
                b = b.add(digit);
            }
        }
        return a.equals(b);
    }
}
