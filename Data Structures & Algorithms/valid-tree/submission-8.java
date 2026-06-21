class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0)
            return true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
        }

        Set<Integer> visited = new HashSet<>();
        return validTree(0, -1, visited, adjList) && visited.size() == n;
    }

    private boolean validTree(
        int edge, int prev, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(edge))
            return false;
        if (!adjList.containsKey(edge))
            return true;
        visited.add(edge);
        for (int currEdge : adjList.getOrDefault(edge, new ArrayList<>())) {
            if (prev == currEdge)
                continue;
            if (!validTree(currEdge, edge, visited, adjList))
                return false;
        }
        return true;
    }
}
