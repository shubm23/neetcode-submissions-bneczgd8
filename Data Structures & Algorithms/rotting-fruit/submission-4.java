class Solution {
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<Edge> queue = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Edge(0, i, j));
                    visited[i][j] = false;
                }
            }
        }
        int minTime = 0;

        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            int time = currentEdge.time;
            int r = currentEdge.row;
            int c = currentEdge.col;
            minTime = Math.max(minTime, time);
            for (int[] dir : directions) {
                orangesRotting(dir[0] + r, dir[1] + c, time, row, col, grid, visited, queue);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        return minTime;
    }

    private void orangesRotting(int r, int c, int t, int tr, int tc, int[][] grid, boolean[][] visited, Queue<Edge> queue) {
        if (r >= tr || c >= tc || c < 0 || r < 0 || visited[r][c] || grid[r][c] != 1) return;
        visited[r][c] = true;
        queue.offer(new Edge(t + 1, r, c));
    }

    private class Edge {
        int time;
        int row;
        int col;

        public Edge(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
}
