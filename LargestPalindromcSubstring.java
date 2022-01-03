/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

 */
import java.util.*;
class Solution {
	//______________________________________________________
	//Polynomial Solution, fails time constraint on imputs >200 chars
    public String longestPalindrome(String s) {
        String largest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                sub += s.charAt(j);
                //sb.append(s.charAt(j));
                if(testPalindrome(sub) && sub.length() > largest.length()) {
                    largest = sub;
                  }
               }
            }
         return largest;        
    } 
    
    public static boolean testPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;                
            }
        }
        return true;
    }
	//______________________________________________________
}

/*
  Test Cases 
"babad"
"p"
"abc"
"abcbcbh"
"abcbcb"
"bcbcbh"
"bcbcbjk"
"jkbcbcb"


*/









