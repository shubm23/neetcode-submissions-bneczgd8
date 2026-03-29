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
   * @param {ListNode} head
   * @return {void}
   */
  reorderList(head) {
    if (!head || !head.next) return;
    
    let curr = head;
    const res = [];

    // Store all node values
    while (curr != null) {
      res.push(curr.val);
      curr = curr.next;
    }

    // Reorder by updating values in the original list
    curr = head;
    let i = 0, j = res.length - 1;

    while (curr != null) {
      if (i <= j) {
        curr.val = res[i];
        i++;
        curr = curr.next;
      }
      
      if (i <= j && curr != null) {
        curr.val = res[j];
        j--;
        curr = curr.next;
      }
    }
  }
}