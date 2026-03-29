class Solution {
    private class Edge implements Comparable<Edge> {
        int time;
        int node;
        
        Edge(int time, int node) {
            this.time = time;
            this.node = node;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.time, other.time);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            int ui = time[0], vi = time[1], ti = time[2];
            adjList.computeIfAbsent(ui, ignore -> new ArrayList<>()).add(new Integer[]{vi, ti});
        }

        int maxTime = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        minHeap.offer(new Edge(0, k));
        Set<Integer> visited = new HashSet<>();
        
        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            int time = current.time;
            int node = current.node;
            
            if (visited.contains(node)) continue;
            visited.add(node);
            maxTime = Math.max(maxTime, time);

            for (Integer[] edge : adjList.getOrDefault(node, new ArrayList<>())) {
                int neighbor = edge[0], weight = edge[1];
                if (!visited.contains(neighbor)) {
                    minHeap.offer(new Edge(time + weight, neighbor));
                }
            }
        }

        return visited.size() == n ? maxTime : -1;
    }
}
