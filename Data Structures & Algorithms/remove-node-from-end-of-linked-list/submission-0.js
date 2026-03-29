class Solution {
    /**
     * @param {ListNode} head
     * @param {number} n
     * @return {ListNode}
     */
    removeNthFromEnd(head, n) {
        // Create a dummy node to handle edge cases (like removing the head)
        let dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers
        let fast = dummy;
        let slow = dummy;
        
        // Move fast pointer n+1 steps ahead
        for (let i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast !== null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}