class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            preMap.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !canFinishDfs(i, state, preMap)) return false;
        }
        return true;
    }

    private boolean canFinishDfs(int crs, int[] state, Map<Integer, List<Integer>> preMap) {
        if (state[crs] == 1) return false; // Cycle detected
        if (state[crs] == 2) return true;  // Already processed

        state[crs] = 1; // Mark as visiting
        List<Integer> prerequisites = preMap.get(crs);
        if (prerequisites != null) {
            for (int pre : prerequisites) {
                if (!canFinishDfs(pre, state, preMap)) return false;
            }
        }
        state[crs] = 2; // Mark as visited
        return true;
    }
}
