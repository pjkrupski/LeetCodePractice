/**
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 */


bool isPalindrome(int x){
    
    //Negatives are never palindromes
    if(x<0){
        return 0;
    }
    int lst[10];    //max and min are 10 chars
    int count = 0;
    //Split into list
    while(x > 9){      //O(10)
        lst[count] = x%10;
        x = x/10;
        count++;
    }
    lst[count] = x;
    
    for(int i = 0; i <= count/2; i++){
        if(lst[i] != lst[count - i]){
            return 0;
        }
    }
    return 1;
}









