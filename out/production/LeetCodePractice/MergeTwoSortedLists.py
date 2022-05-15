"""
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
"""

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode(0, None)
        head = temp
        while list1 and list2:
            if (list1.val < list2.val):
                temp.next = list1
                list1 = list1.next
            else:
                temp.next = list2
                list2 = list2.next
            temp = temp.next
        temp.next = list1 or list2
        return head.next
        
        
"""
Test Cases
[]
[]
[9]
[]
[]
[4]
[9,9,9]
[1,1,1]
[1,1,1]
[9,9,9]
[1,2,4]
[1,3,4]
[-100, -99, -88]
[96, 98, 100]

"""


"""
Lessons learned

Notes
head.val = 0
list starts with empty node

Once one list is exhausted, the combined list just needs to be set to the 
current node of the next list, no need to finish traversing the second list

Logical or can be used on list1 and list2 for determining which still has values

Let B be size of big list and S be size of small list
runtime of O(S)


"""






                