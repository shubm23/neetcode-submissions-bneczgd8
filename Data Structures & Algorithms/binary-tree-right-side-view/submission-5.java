/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        int level = 0;
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()) {
            int size = treeNodeDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeDeque.poll();
                if (node == null)
                    continue;
                if (level == res.size()) {
                    res.add(node.val);
                }
                if (node.right != null)
                    treeNodeDeque.offer(node.right);
                if (node.left != null)
                    treeNodeDeque.offer(node.left);
            }
            level++;
        }
        return res;
    }
}
