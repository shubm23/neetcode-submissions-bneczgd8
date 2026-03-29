
class Solution{
public void islandsAndTreasure(int[][] grid) {
    if (grid == null || grid.length == 0) return;
    int rows = grid.length, cols = grid[0].length;
    Deque<int[]> q = new ArrayDeque<>();
    
    // Instead of a Set, use a boolean array for O(1) lookup and memory efficiency
    boolean[][] visited = new boolean[rows][cols];

    // Initialize: Add all gates (0) to the queue
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 0) {
                q.add(new int[]{i, j});
                visited[i][j] = true;
            }
        }
    }

    int dist = 0;
    while (!q.isEmpty()) {
        int size = q.size(); // Capture size for the current level
        for (int i = 0; i < size; i++) {
            int[] curr = q.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            grid[r][c] = dist;

            // Check all 4 directions
            addRoom(r + 1, c, rows, cols, grid, visited, q);
            addRoom(r - 1, c, rows, cols, grid, visited, q);
            addRoom(r, c + 1, rows, cols, grid, visited, q);
            addRoom(r, c - 1, rows, cols, grid, visited, q);
        }
        dist++;
    }
}

// Helper method is cleaner than a BiFunction here
private void addRoom(int r, int c, int rows, int cols, int[][] grid, boolean[][] visited, Deque<int[]> q) {
    if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == -1) {
        return;
    }
    visited[r][c] = true;
    q.add(new int[]{r, c});
}
}