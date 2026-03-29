/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {number[][]}
     */
levelOrder(root) {
    const queue = [root];
    const res = [];
    if(!root) return [];
    while (queue.length > 0) {
      const queueLen = queue.length;
      const currentLevel = [];
      for (let i = 0; i < queueLen; i++) {
        const currentNode = queue.shift();
        currentLevel.push(currentNode?.val);
        if (currentNode?.left) queue.push(currentNode?.left);
        if (currentNode?.right) queue.push(currentNode?.right);
      }
      res.push(currentLevel);
    }
    return res;
  }
    }
