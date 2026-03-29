class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int key = pre[0];
            int val = pre[1];
            adjList.computeIfAbsent(key, (k) -> new ArrayList<>()).add(val);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!findOrderDfs(i, visited, adjList, order)) return new int[0];
        }
        return order.stream().mapToInt(i -> i).toArray();
    }
    private boolean findOrderDfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> adjList, List<Integer> order) {
        if (visited.contains(i)) return false;
        if (adjList.containsKey(i) && adjList.get(i).isEmpty()) return true;
        visited.add(i);
        for (Integer pre : adjList.getOrDefault(i, new ArrayList<>())) {
            if (!findOrderDfs(pre, visited, adjList, order)) return false;
        }
        visited.remove(i);
        adjList.put(i, new ArrayList<>());
        order.add(i);
        return true;
    }
}

