class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> adjList = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int[] time : times) {
            int u = time[0], v = time[1], wieght = time[2];
            adjList.computeIfAbsent(u, key -> new ArrayList<>()).add(new Integer[] {v, wieght});
        }
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new Integer[] {k, 0});
        Set<Integer> visited = new HashSet<>();

        int maxTime = 0;

        while (!minHeap.isEmpty()) {
            Integer[] pollElement = minHeap.poll();
            int v = pollElement[0];
            int d = pollElement[1];
            if (visited.contains(v))
                continue;
            visited.add(v);
            maxTime = Math.max(maxTime, d);

            for (Integer[] node : adjList.getOrDefault(v, new ArrayList<>())) {
                int nei = node[0], w = node[1];
                if (!visited.contains(nei)) {
                    minHeap.offer(new Integer[] {nei, d+w});
                }
            }
        }
        return visited.size() != n ? -1 : maxTime;
    }
}
