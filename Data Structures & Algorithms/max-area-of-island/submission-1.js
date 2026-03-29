class Solution {
  /**
   * @param {number[][]} grid
   * @return {number}
   */
  maxAreaOfIsland(grid) {
    if (grid.length === 0) return 0;
    const rows = grid.length;
    const cols = grid[0].length;
    const visited = Array.from({ length: rows }, () =>
      new Array(cols).fill(false),
    );
    let maxArea = 0;
    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (grid[i][j] === 1 && visited[i][j] === false) {
          const area = this.dfs(i, j, rows, cols, visited, grid);
          maxArea = Math.max(maxArea, area);
        }
      }
    }
    return maxArea;
  }

  dfs(i, j, rows, cols, visited, grid) {
    if (
      i < 0 ||
      j < 0 ||
      i >= rows ||
      j >= cols ||
      visited[i][j] === true ||
      grid[i][j] === 0
    )
      return 0;
    visited[i][j] = true;
    let area = 1;
    area += this.dfs(i - 1, j, rows, cols, visited, grid); // up
    area += this.dfs(i + 1, j, rows, cols, visited, grid); // down
    area += this.dfs(i, j - 1, rows, cols, visited, grid); // left
    area += this.dfs(i, j + 1, rows, cols, visited, grid); // right
    return area;
  }
}