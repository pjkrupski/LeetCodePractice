/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

// Definition for singly-linked list.




public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        int carry = 0;


        //Preprocess
        //add first numbers
        if(l1.val + l2.val > 9){
            answer.val = (l1.val + l2.val) - 10;
            System.out.println("Set answer val to "+ ((l1.val + l2.val) - 10));
            carry = 1;
        }else {
            answer.val = l1.val + l2.val;
            System.out.println("Set answer val to "+ (l1.val + l2.val));
        }


        //move lists forward by 1
        if(l1.next != null) {
            l1 = l1.next;
        }else{
            l1 = null;
        }

        if(l2.next != null) {
            l2 = l2.next;
        }else{
            l2 = null;
        }

        //Build remaining part of answer
        while(l1 != null || l2 != null){
            System.out.println("while");
            ListNode temp = new ListNode();
            temp.next = answer;
            answer = temp;
            //temp.next = answer.next;
            //answer.next = temp;

            if(l1 != null && l2 != null){
                if(l1.val + l2.val + carry > 9){
                    answer.val = (l1.val + l2.val + carry) - 10;
                    System.out.println("Set answer val to "+ ((l1.val + l2.val + carry) - 10));
                    carry = 1;
                }else{
                    answer.val = l1.val + l2.val + carry;
                    System.out.println("Set answer val to "+ (l1.val + l2.val + carry));
                    carry = 0;
                }
            }else if (l1 != null && l2 == null){
                if(l1.val + carry > 9){
                    answer.val = (l1.val + carry) - 10;
                    System.out.println("Set answer val to "+ ((l1.val + carry) - 10));
                    carry = 1;
                }else{
                    answer.val = l1.val + carry;
                    System.out.println("Set answer val to "+ (l1.val + carry));
                    carry = 0;
                }
            }else if(l1 == null && l2 != null){
                if(l2.val + carry > 9){
                    answer.val = (l2.val + carry) - 10;
                    System.out.println("Set answer val to "+ ((l2.val + carry) - 10));
                    carry = 1;
                }else{
                    answer.val = l2.val + carry;
                    System.out.println("Set answer val to "+ ( l2.val + carry));
                    carry = 0;
                }
            }

            //Needs try catch to avoid null pointer becasue Node: next is not initialized as null
            try{
                if(l1.next != null) {
                    l1 = l1.next;
                }else{
                    l1 = null;
                }
            }catch(NullPointerException e){
                l1 = null;
            }
            try{
                if(l2.next != null) {
                    l2 = l2.next;
                }else{
                    l2 = null;
                }
            }catch(NullPointerException e){
                l2 = null;
            }
        }

        //Post Process: Handle extra carry
        if(carry == 1){
            ListNode temp = new ListNode();
            temp.next = answer;
            answer = temp;
            //temp.next = answer.next;
            //answer.next = temp;
            answer.val = 1;
            System.out.println("set answer val to "+ 1);
        }


        //Reverse answer since numbers were adding to the front
        ListNode prev = null;
        ListNode current = answer;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        answer = prev;

        return answer;
    }
}
