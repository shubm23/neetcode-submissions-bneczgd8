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
   * @return {ListNode}
   */
  reverseList(head) {
    let prev = null;
    let currHead = head;
    while(currHead != null){
      let next = currHead.next;
      currHead.next = prev;
      prev = currHead;
      currHead = next;
    }
    return prev;
  }
}