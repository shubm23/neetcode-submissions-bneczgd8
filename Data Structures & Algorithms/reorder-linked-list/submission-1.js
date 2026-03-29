class Solution {
  /**
   * @param {ListNode} head
   * @return {void}
   */
  reorderList(head) {
    if (!head || !head.next) return;
    let slow = head,
      fast = head.next;

    while (fast && fast.next) {
      slow = slow.next;
      fast = fast.next.next;
    }

    let second = slow.next;
    slow.next = null;
    let prev = null;

    while (second) {
      let temp = second.next;
      second.next = prev;
      prev = second;
      second = temp;
    }

    let first = head;
    second = prev;

    while(second){
      let tmp1 = first.next, tmp2 = second.next;
      first.next = second;
      second.next = tmp1;
      first = tmp1, second = tmp2
    }

  }
}