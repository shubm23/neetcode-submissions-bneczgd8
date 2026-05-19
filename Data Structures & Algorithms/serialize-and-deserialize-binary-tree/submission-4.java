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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeDfs(root, res);
        return String.join(",", res);
    }

    private void serializeDfs(TreeNode treeNode, List<String> res) {
        if (treeNode == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(treeNode.val));
        serializeDfs(treeNode.left, res);
        serializeDfs(treeNode.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int[] i = {0};
        return deserializeDfs(strs, i);
    }

    private TreeNode deserializeDfs(String[] res, int[] i) {
        if (res[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(res[i[0]]));
        i[0]++;
        node.left = deserializeDfs(res, i);
        node.right = deserializeDfs(res, i);
        return node;
    }
}
