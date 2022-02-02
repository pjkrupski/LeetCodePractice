/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
 */
class DetectCapital {
    public boolean detectCapitalUse(String word) {
        Set<Character> caps = new HashSet<Character>();
        char [] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i = 0; i < 26; i++){
            caps.add(chars[i]);            
        }
        
        //Edge case
        if(word.length() == 1){
            return true;
        }
        
        if(caps.contains(word.charAt(0)) && caps.contains(word.charAt(1))){
            for(int j = 2; j < word.length(); j++){
                //Verify all are caps
                if(!caps.contains(word.charAt(j))){
                    return false;
                }
            }
        } else {
            //Verify rest are lowercase
            for(int j = 1; j < word.length(); j++){
                if(caps.contains(word.charAt(j))){
                    return false;
                }
            }
        }       
        return true;
    }
}
