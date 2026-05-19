class Codec {
    private static final String NULL = "N";
    private static final String SEP = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    private void serializeDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] idx = {0};
        return deserializeDfs(nodes, idx);
    }

    private TreeNode deserializeDfs(String[] nodes, int[] idx) {
        if (nodes[idx[0]].equals(NULL)) {
            idx[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;

        node.left = deserializeDfs(nodes, idx);
        node.right = deserializeDfs(nodes, idx);

        return node;
    }
}