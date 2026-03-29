class Solution {
    /**
     * @param {TreeNode} root
     * @param {number} k
     * @return {number}
     */
    kthSmallest(root, k) {
      let count = 0 , res = null;
      
      (function inorder(root){
        if(root === null || res !== null) return;
        inorder(root?.left);
        count++;
        if(count === k){
          res = root.val;
          return;
        }
        inorder(root?.right);
      })(root);

      return res;
    }
}
