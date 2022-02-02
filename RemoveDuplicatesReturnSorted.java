/*
"a"
"aa"
"aaaa"
"ab"
"acb"
"aacddfg"

 */
import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Set set = new HashSet();
        for(char temp: s.toCharArray()){
            if(!set.contains(temp)){
                set.add(temp);
                //Check 2 cases when char is appended to end
                if(sb.length() == 0 || temp >= sb.charAt(sb.length() - 1)){
                    sb.append(temp);
                } else{
                    //Find correct index
                    for(int i = 0; i < sb.length(); i++){
                        if(temp <= sb.charAt(i)){
                            //Stop searching once inserted
                            sb.insert(i, temp);
                            break;
                        }
                    }    
                }
            }
        }
        return sb.toString();
    }
}
