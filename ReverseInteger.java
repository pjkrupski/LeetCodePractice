/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

 */
import java.util.*;
class ReverseInteger {
    public int reverse(int x) {
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        
        //Smallest Value edge case
        if(x == -2147483648){
            return 0;           
        }
        
        //Negative Check
        if(x < 0){
            x *= -1;
            negative = true;
        }
        
        while(x > 9){  
            sb.append(x % 10);
            x /= 10;
        }
        
        //Last digit
        sb.append(x);
        //Store parse as long since result may be out of bounds for int
        long temp = Long.parseLong(sb.toString());  
        
        //Check bounds before converting to int
        if(temp > (long) Math.pow(2.0, 31.0) || temp < -1 * (long) Math.pow(2.0, 31.0)){
            return 0;
        } 
        
        
        //Convert to neg or pos int if sb is within bounds
        if(negative){
            x = -1 * Integer.parseInt(sb.toString());
        } else {
            x = Integer.parseInt(sb.toString());
        }
          
        return x;
    }
}

/*
  Test Cases
  
123
-143
10
1010
10201
-1009
120
1534236469
1999999999
-900000
-2147483648

*/