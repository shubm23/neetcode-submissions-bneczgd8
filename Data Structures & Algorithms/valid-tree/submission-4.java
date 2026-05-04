class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return validTreeDfs(0, -1, visited, adjList) && visited.size() == n;

    }

    private boolean validTreeDfs(int edge, int prev, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(edge)) return false;
        if (!adjList.containsKey(edge)) return true;
        visited.add(edge);
        for (Integer e : adjList.getOrDefault(edge, new ArrayList<>())) {
            if (prev == e) continue;
            if (!validTreeDfs(e, edge, visited, adjList)) return false;
        }
        return true;
    }
}
