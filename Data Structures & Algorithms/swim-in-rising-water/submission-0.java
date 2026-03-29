class Solution {
    private static class Edge1 implements Comparable<Edge1> {
        int time;
        int row;
        int col;

        Edge1(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Edge1 other) {
            return Integer.compare(this.time, other.time);
        }
    }
     public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge1> minHeap = new PriorityQueue<>();
        minHeap.offer(new Edge1(grid[0][0], 0, 0));
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited.add("0-0");
        while (!minHeap.isEmpty()) {
            Edge1 edge1 = minHeap.poll();
            int r = edge1.row, c = edge1.col, t = edge1.time;
            if (r == n - 1 && c == n - 1) return t;
            for (int[] dir : direction) {
                int nR = dir[0] + r, nC = dir[1] + c;
                if (nR < 0 || nC < 0 || nR == n || nC == n || visited.contains(nR + "-" + nC)) continue;
                visited.add(nR + "-" + nC);
                minHeap.offer(new Edge1(Math.max(t, grid[nR][nC]), nR, nC));
            }
        }
        return -1;
    }
}
