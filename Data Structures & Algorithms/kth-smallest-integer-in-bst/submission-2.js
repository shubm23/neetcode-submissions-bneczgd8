class Solution {
  kthSmallest(root, k) {
    let result;
    
    function dfs(node) {
      if (!node || k === 0) return;

      dfs(node.left);

      if (--k === 0) {
        result = node.val;
        return;
      }

      dfs(node.right);
    }

    dfs(root);
    return result;
  }
}
