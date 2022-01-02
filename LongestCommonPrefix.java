/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

 */
import java.util.*;
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = 0, min = 0;
        boolean empty = true;
        boolean noPrefix = false;
        
        //Check single string case
        if(strs.length == 1){
            return strs[0];
        }
        
        
        //Check "" case
        for(int i = 0; i < strs.length; i++){
            if(!strs[i].equals("")){
                empty = false;
                break;
            }
        }
        
        if(empty == true){
            return "";
        }
    

        //Get min length
        min = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < min){
                min = strs[i].length();
            }
        }
        
        
        //Find longest prefix
        //i = stringIndex, j = string in list
        for(int i = 0; i < min; i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    if(len == 0){
                        return "";
                    }else{
                        return strs[0].substring(0, len);
                    }                    
                }                
            }
            len++;   
        }
        
       
        return strs[0].substring(0, len);
        
    }
}

//Improvments
/*
  Combine 2 for loops and 1 double for
  use for each
  
*/

//Test Cases
/*
["flower","flow","flight"]
["", "", "", ""]
[""]
["string"]
["abc","bbc","cbc"]
["testcasee","testcase","testcase"]
["testcase","testcase","testcaseee"]
["testcase","","testcaseee"]
["testcase","",""]
["flowera","flowerb","flowerc"]
["f","f","g"]

*/
    
    
    
