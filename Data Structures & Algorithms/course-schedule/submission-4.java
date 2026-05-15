class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int src = pre[0], dest = pre[1];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }

        Set<Integer> visted = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDfs(i, visted, adjList))
                return false;
        }
        return true;
    }

    private boolean canFinishDfs(int e, Set<Integer> visted, Map<Integer, List<Integer>> adjList) {
        if (visted.contains(e))
            return false;
        if (adjList.getOrDefault(e, new ArrayList<>()).isEmpty())
            return true;
        visted.add(e);
        for (int nei : adjList.getOrDefault(e, new ArrayList<>())) {
            if (!canFinishDfs(nei, visted, adjList))
                return false;
        }
        visted.remove(e);
        adjList.put(e, new ArrayList<>());
        return true;
    }
}
