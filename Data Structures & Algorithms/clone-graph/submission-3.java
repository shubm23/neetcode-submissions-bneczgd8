/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> memo = new HashMap<>();
        return cloneGraph(node, memo);
    }

    public Node cloneGraph(Node node, Map<Integer, Node> memo) {
        if (memo.containsKey(node.val))
            return memo.get(node.val);
        Node currNode = new Node(node.val);
        memo.put(currNode.val, currNode);
        for (Node nei : node.neighbors) {
            currNode.neighbors.add(cloneGraph(nei, memo));
        }
        return currNode;
    }
}