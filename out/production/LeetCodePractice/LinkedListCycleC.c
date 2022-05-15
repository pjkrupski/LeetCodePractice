/**
Given the head of a linked list, return the node where the cycle begins. 
If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that 
can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next 
pointer is connected to (0-indexed). It is -1 if there is no cycle. 
Note that pos is not passed as a parameter.

Do not modify the linked list.

 
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {  
    //Build duplicate list with each element being
    struct ListNode *slow = head, *fast = head;
    while(fast != NULL && fast->next != NULL){
        //Traverse to next
        slow = slow->next;
        fast = fast->next->next;
        //Check equal
        if(fast == slow){
            //Cycle found, now find start
            slow = head;
            while(slow != fast){
                slow = slow->next;
                fast = fast->next;
            }
            return slow;
        }
    }
    return NULL;  
}


/*
  Test Cases
[1]
-1
[]
-1
[3,2,0,-4]
-1
[-100000,100000]
-1
[1,2,1,2,1,2]
-1
[1,1,1,1,1,1,1]
-1
[1,2,3,4]
1
[1,2,3,4,5]
1
[1,2,3,4,5]
2
[1,2,3,4]
3
*/









