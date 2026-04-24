class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int source = pre[0], destination = pre[1];
            adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDfs(i, adjList, visited)) return false;
        }
        return true;
    }

    private boolean canFinishDfs(int i, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(i)) return false;
        if (adjList.containsKey(i) && adjList.get(i).isEmpty()) return true;
        visited.add(i);
        for (int idx : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!canFinishDfs(idx, adjList, visited)) return false;
        }
        visited.remove(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}
