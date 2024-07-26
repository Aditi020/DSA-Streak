// Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.
// A single operation consists of swapping an existing alphabetic character with any other alphabetic character.
// Note - A pangram is a sentence containing every letter in the english alphabet.
// Examples :
// Input: str = "the quick brown fox jumps over the lazy dog", k = 0
// Output: true
// Explanation: the sentence contains all 26 characters and is already a pangram.
// Input: str = "aaaaaaaaaaaaaaaaaaaaaaaaaa", k = 25 
// Output: true
// Explanation: The word contains 26 instances of 'a'. Since only 25 operations are allowed. We can keep 1 instance and change all others to make str a pangram.
// Input: str = "a b c d e f g h i j k l m", k = 20
// Output: false

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:

    bool kPangram(string str, int k) {
        // code here
        vector<int> ok(26,0);
        for(int i =0;i< str.size();i++){
            if(str[i] >='a' && str[i] <='z'){
                ok[str[i] -'a']++;
            }
        }
        int cnt =0;
        int extra =0;
        for(int i=0;i< 26;i++){
            if(ok[i] >0){
                cnt++;
                extra+=ok[i] -1;
            }
        }
       if(cnt == 26){
           return true;
       }
       int want =26- cnt;
       return extra >= want && want <=k;
    }
};
