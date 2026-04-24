class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int source = pre[0], destination = pre[1];
            adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!findOrderDfs(i, adjList, visited, res)) return new int[]{};
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderDfs(int i, Map<Integer, List<Integer>> adjList, Set<Integer> visited, List<Integer> res) {
        if (visited.contains(i)) return false;
        if (adjList.containsKey(i) && adjList.get(i).isEmpty()) return true;
        visited.add(i);
        for (int idx : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!findOrderDfs(idx, adjList, visited, res)) return false;
        }
        visited.remove(i);
        adjList.put(i, new ArrayList<>());
        res.add(i);
        return true;
    }
}

