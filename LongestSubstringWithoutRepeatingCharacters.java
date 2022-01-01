/*
iven a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> lettersForward = new HashSet();
        Set<Character> lettersBackward = new HashSet();
        List<Integer> lengthsForward = new ArrayList();
        List<Integer> lengthsBackward = new ArrayList();
        int sizeForward = 0;
        int sizeBackward = 0;



        //Needs double for to loop through substrings of string
        //Still needs double variables to test forward and back


        //Find lengths of all substrings
        for(int i = 0; i < s.length(); i++){
            if(lettersForward.contains(s.charAt(i))){
                lettersForward.clear();
                lengthsForward.add(sizeForward);
                sizeForward = 0;
            }

            if(lettersBackward.contains(s.charAt((s.length() - 1) - i))){
                lettersBackward.clear();
                lengthsBackward.add(sizeBackward);
                sizeBackward = 0;
            }



            lettersForward.add(s.charAt(i));
            lettersBackward.add(s.charAt((s.length() - 1) - i));
            sizeForward++;
            sizeBackward++;
        }






        //Retrieve length of longest forward
        for(int i = 0; i < lengthsForward.size(); i++){
            if(lengthsForward.get(i) > sizeForward){
                sizeForward = lengthsForward.get(i);
            }
        }

        //Retrieve length of longest backward
        for(int i = 0; i < lengthsBackward.size(); i++){
            if(lengthsBackward.get(i) > sizeBackward){
                sizeBackward = lengthsBackward.get(i);
            }
        }


        if(sizeBackward >= sizeForward){
            return sizeBackward;
        }else{
            return sizeForward;
        }
    }
}
