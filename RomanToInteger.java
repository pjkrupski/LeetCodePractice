/*
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

 */
import java.util.*;
class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        //Len 1
        if(s.length() == 1){
            return map.get(s.charAt(0));
        }
        
        
        //Loop input
        for(int i = 0; i < s.length(); i++){
                    
            //Subtraction Check
            //Error check length before comparring next char
            if(i < s.length() - 1){
                if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    sum += map.get(s.charAt(i+1)) - 1;  
                    i++;
                    continue;
                }else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    sum += map.get(s.charAt(i+1)) - 10;   
                    i++;
                    continue;
                }else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    sum += map.get(s.charAt(i+1)) - 100;  
                    i++;
                    continue;
                }                
            }
            
            //Normal addition case
            sum += map.get(s.charAt(i));            
            
        }
        return sum;
    }
}

//Potential Upgrades
//Enhanced for
//Switch statement


/*
 
 Test Cases 
 
"I"
"V"
"M"
"C"
"D"
"IV"
"IX"
"XC"
"XL"
"CD"
"CM"
"III"
"LVIII"
"MCMXCIV"
"MDLVII"

*/