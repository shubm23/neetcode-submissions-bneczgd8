class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int key = pre[0];
            int val = pre[1];
            adjList.computeIfAbsent(key, (k) -> new ArrayList<>()).add(val);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDfs(i, visited, adjList)) return false;
        }
        return true;
    }

    private boolean canFinishDfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(i)) return false;
        if (adjList.containsKey(i) && adjList.get(i).isEmpty()) return true;
        visited.add(i);
        for (Integer pre : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!canFinishDfs(pre, visited, adjList)) return false;
        }
        visited.remove(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}
