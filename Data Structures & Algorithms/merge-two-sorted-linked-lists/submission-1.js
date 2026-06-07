/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
  /**
   * @param {ListNode} list1
   * @param {ListNode} list2
   * @return {ListNode}
   */
  mergeTwoLists(list1, list2) {
    let newNode = new ListNode(0);
    let curr = newNode;
    let currHead1 = list1;
    let currHead2 = list2;

    while (currHead1 != null && currHead2 != null) {
      if (currHead1.val <= currHead2.val) {
        curr.next = currHead1;
        currHead1 = currHead1.next;
      } else {
        curr.next = currHead2;
        currHead2 = currHead2.next;
      }
      curr = curr.next;
    }

    if (currHead1 === null) {
      curr.next = currHead2;
    } else if (currHead2 === null) {
      curr.next = currHead1;
    }

    return newNode.next;
  }
}