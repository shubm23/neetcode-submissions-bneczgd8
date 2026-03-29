class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            preMap.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !findOrderDfs(i, state, preMap, order)) {
                return new int[0]; // Cycle detected
            }
        }
        return order.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderDfs(int crs, int[] state, Map<Integer, List<Integer>> preMap, List<Integer> order) {
        if (state[crs] == 1) return false; // Cycle detected
        if (state[crs] == 2) return true;  // Already processed

        state[crs] = 1; // Mark as visiting
        List<Integer> prerequisites = preMap.get(crs);
        if (prerequisites != null) {
            for (int pre : prerequisites) {
                if (!findOrderDfs(pre, state, preMap, order)) return false;
            }
        }
        state[crs] = 2; // Mark as visited
        order.add(crs); // Add after all prerequisites are processed
        return true;
    }
}
