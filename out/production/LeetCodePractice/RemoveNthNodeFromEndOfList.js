/*
   Problem Statement
   
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

*/



/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    //Single element edge case
    if(head.next == null){
        return null;
    }
    let index = 0;
    let temp = head;
    while(temp){
        index++
        temp = temp.next;
    }    
    
    //Removing first element edge case
    if(n == index){
        head = head.next;
        return head;
    }
    
    let target = index - n;
    temp = head;
    index = 0;
    while(temp){
        if(index == target - 1){
           //Delete
            temp.next = temp.next.next;
           console.log(temp.val); 
        }
        index++;
        temp = temp.next;                  
    } 
    
    return head;
};
/*
  Test Cases


*/