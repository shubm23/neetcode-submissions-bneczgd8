class Solution {
    private static class Edge2 implements Comparable<Edge2> {
        int cost;
        int node;

        Edge2(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Edge2 other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
     public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Edge2>> adjList = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjList.computeIfAbsent(i, (key) -> new ArrayList<>()).add(new Edge2(dist, j));
                adjList.computeIfAbsent(j, (key) -> new ArrayList<>()).add(new Edge2(dist, i));
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge2> minHeap = new PriorityQueue<>();
        minHeap.offer(new Edge2(0, 0));
        while (visited.size() < points.length) {
            Edge2 edge = minHeap.poll();
            if (visited.contains(edge.node)) continue;
            res += edge.cost;
            visited.add(edge.node);
            for (Edge2 edg : adjList.getOrDefault(edge.node, new ArrayList<>())) {
                if (visited.contains(edg.node)) continue;
                minHeap.offer(new Edge2(edg.cost, edg.node));
            }
        }
        return res;
    }
}
