class Solution {
  public int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int numOfIsland = 0;
    boolean[][] visited = new boolean[row][col];

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        visited[r][c] = false;
      }
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (grid[r][c] == '1' && !visited[r][c]) {
          dfs(r, c, visited, grid);
          numOfIsland++;
        }
      }
    }

    return numOfIsland;
  }

  private void dfs(int r, int c, boolean[][] visited, char[][] grid) {
    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'
        || visited[r][c])
      return;
    visited[r][c] = true;
    dfs(r + 1, c, visited, grid);
    dfs(r, c + 1, visited, grid);
    dfs(r - 1, c, visited, grid);
    dfs(r, c - 1, visited, grid);
  }
}
