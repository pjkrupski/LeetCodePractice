/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        //Empty List edge case
        if(head == null){
            return null;
        }
        Set values = new HashSet();
        ListNode newLst = head;
        ListNode newHead = newLst;
        ListNode temp = head.next;
        values.add(head.val);
        while(temp != null){
            if(!values.contains(temp.val)){
                values.add(temp.val);
                newLst.next = temp;  
                newLst = newLst.next;
            }
            temp = temp.next;
        }
        newLst.next = null;
        return newHead;
    }
}
