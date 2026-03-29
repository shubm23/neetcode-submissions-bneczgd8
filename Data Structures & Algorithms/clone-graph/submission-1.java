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
        Map<Integer,Node> visited = new HashMap<>();
        return node == null ? null : this.cloneGraphDfs(node,visited);
    }
    
    private Node cloneGraphDfs(Node node,Map<Integer,Node> visited){
        if(visited.containsKey(node.val)) return visited.get(node.val);
        Node clone = new Node(node.val);
        visited.put(clone.val,clone);
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraphDfs(neighbor,visited));
        }
        return clone;
    }
}