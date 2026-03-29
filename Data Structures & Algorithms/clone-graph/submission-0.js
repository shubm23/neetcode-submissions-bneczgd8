/**
 * // Definition for a Node.
 * class Node {
 *     constructor(val = 0, neighbors = []) {
 *       this.val = val;
 *       this.neighbors = neighbors;
 *     }
 * }
 */

class Solution {
    /**
     * @param {Node} node
     * @return {Node}
     */
    cloneGraph(node) {
      const dict = {};
      
      function clone(node){
        if(dict?.[node.val])return dict[node.val];
        const copy = new Node(node?.val);
        dict[node.val] = copy;
        for(const neighbor of node.neighbors){
          copy.neighbors.push(clone(neighbor));
        }
        return copy;
      }
      
      return node === null ? null : clone(node);
      
    }
}