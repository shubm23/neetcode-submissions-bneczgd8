// class Node {
//   constructor(val, next = null, random = null) {
//       this.val = val;
//       this.next = next;
//       this.random = random;
//   }
// }

class Solution {
    /**
     * @param {Node} head
     * @return {Node}
     */
    copyRandomList(head) {
        if (!head) return null;
        
        const map = new Map();
        
        // First pass: Create all nodes
        let curr = head;
        while (curr) {
            map.set(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Second pass: Set next and random pointers
        curr = head;
        while (curr) {
            const copy = map.get(curr);
            copy.next = map.get(curr.next) || null;
            copy.random = map.get(curr.random) || null;
            curr = curr.next;
        }
        
        return map.get(head);
    }

}
