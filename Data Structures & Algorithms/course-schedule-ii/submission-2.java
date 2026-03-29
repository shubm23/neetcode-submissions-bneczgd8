class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0], value = prerequisite[1];
            adjList.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!findOrderDfs(i, visited, res, adjList)) return new int[]{};
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderDfs(int i, Set<Integer> visited, List<Integer> res, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(i)) return false;
        if (adjList.containsKey(i) && adjList.getOrDefault(i, new ArrayList<>()).isEmpty()) return true;
        visited.add(i);
        for (int idx : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!findOrderDfs(idx, visited, res, adjList)) return false;
        }
        visited.remove(i);
        res.add(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}

