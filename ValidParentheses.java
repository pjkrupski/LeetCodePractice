/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */
import java.util.*;
class ValidParentheses {
 
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<Character>();
        
        //All odd number nputs are invalid
        if(s.length() % 2 != 0){
            return false;
        }
        
        for(int i = 0; i < s.length(); i++){
            
            switch (s.charAt(i)) {
                case ')':
                    if(open.empty()){
                        return false;                        
                    } else if(open.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(open.empty()){
                        return false;                        
                    } else if(open.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(open.empty()){
                        return false;                        
                    } else if(open.pop() != '{'){
                        return false;
                    }
                    break;
                default:
                    open.push(s.charAt(i));
            }
        }
        
        if(open.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
}

/*
Test Cases

"()"
"[["
"){"
"(){"
"()[]{}"
"()[]{}{}{}[]()"
"()[]{}{{}[]()}"
"({[]})"
"({[]}){}{}[]"
"[(()()(){[]})]"
"[(()()(){[]})}"
"[([)(}(){[]})]"

*/
