class Edge implements Comparable<Edge> {
    int x;
    int y;
    double closet;

    public Edge(int x, int y, double closet) {
        this.x = x;
        this.closet = closet;
        this.y = y;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.closet, o.closet);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        for (int[] point : points) {
            int x1 = 0, y1 = 0, x2 = point[0], y2 = point[1];
            double dist = getEuclideanDist(x1, x2, y1, y2);
            minHeap.offer(new Edge(x2, y2, dist));
        }

        int[][] res = new int[k][2];

        for (int i = k - 1; i >= 0; i--) {
            Edge edge = minHeap.poll();
            res[i] = new int[] {edge.x, edge.y};
        }
        return res;
    }

    private double getEuclideanDist(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
