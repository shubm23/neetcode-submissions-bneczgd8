class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] e : edges) {
            adjList.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adjList.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return validTreeDfs(0, -1, visited, adjList) && visited.size() == n;
    }

    private boolean validTreeDfs(int i, int prev, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(i)) return false;
        visited.add(i);
        if(!adjList.containsKey(i)) return true;
        for (int j : adjList.get(i)) {
            if (j == prev) continue;
            if (!validTreeDfs(j, i, visited, adjList)) return false;
        }
        return true;
    }
}
