class Codec {
  /**
   * Encodes a tree to a single string.
   *
   * @param {TreeNode} root
   * @return {string}
   */
  serialize(root) {
    let res = [];

    function dfs(root) {
      if (!root) {
        res.push('N');
        return;
      }

      res.push(root?.val);
      dfs(root?.left);
      dfs(root?.right);
    }

    dfs(root);

    return res.join(',');
  }

  /**
   * Decodes your encoded data to tree.
   *
   * @param {string} data
   * @return {TreeNode}
   */
  deserialize(data) {
    const tree = data.split(',');
    let i = 0;
    function dfs() {
      if (tree[i] === 'N') {
        i++;
        return null;
      }
      const node = new TreeNode(Number(tree[i]));
      i++;
      node.left = dfs();
      node.right = dfs();
      return node;
    }

    return dfs();
  }
}