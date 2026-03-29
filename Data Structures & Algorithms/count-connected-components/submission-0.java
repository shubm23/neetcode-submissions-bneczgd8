class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                countComponentsDfs(i, visited, adjList);
                count++;
            }
        }
        return count;
    }

    private void countComponentsDfs(int node, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        visited[node] = true;
        for (int nei : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited[nei]) {
                countComponentsDfs(nei, visited, adjList);
            }
        }
    }
}
