class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int src = pre[0], dst = pre[1];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, visited, adjList))
                return false;
        }

        return true;
    }

    private boolean canFinish(int i, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(i))
            return false;
        if (adjList.containsKey(i) && adjList.get(i).isEmpty())
            return true;
        visited.add(i);
        for (Integer nei : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!canFinish(nei, visited, adjList))
                return false;
        }
        visited.remove(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}
