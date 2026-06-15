public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pre : prerequisites) {
            int src = pre[0], dest = pre[1];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!findOrderDfs(i, visited, order, adjList)) return new int[0];
        }
        return order.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderDfs(int src, Set<Integer> visited, List<Integer> order, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(src)) return false;
        if (adjList.containsKey(src) && adjList.get(src).isEmpty()) return true;
        visited.add(src);
        for (int nei : adjList.getOrDefault(src, new ArrayList<>())) {
            if (!findOrderDfs(nei, visited, order, adjList)) return false;
        }
        visited.remove(src);
        adjList.put(src, new ArrayList<>());
        order.add(src);
        return true;
    }
}