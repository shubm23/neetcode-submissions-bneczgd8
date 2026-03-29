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
     * @return {number}
     */
    maxPathSum(root) {
      let res = root?.val;

      (function dfs(root){
        if(!root) return 0;
        let lMax = dfs(root.left);
        let rMax = dfs(root.right);
        lMax = Math.max(lMax,0);
        rMax = Math.max(rMax,0);

        res = Math.max(res, root.val+lMax+rMax);

        return root.val + Math.max(lMax,rMax);
      })(root);

      return res;
    }
}
