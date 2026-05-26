class Solution {
  /**
   * @param {character[][]} grid
   * @return {number}
   */
  numIslands(grid) {
    if (grid.length === 0) return 0;
    const rows = grid.length;
    const cols = grid[0].length;
    const visited = Array.from({ length: rows }, () =>
      new Array(cols).fill(false),
    );
    let noIsland = 0;

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (grid[i][j] === "1" && visited[i][j] === false) {
          this.dfs(i, j, rows, cols, visited, grid);
          noIsland++;
        }
      }
    }

    return noIsland;
  }

  dfs(i, j, rows, cols, visited, grid) {
    if (
      i < 0 ||
      j < 0 ||
      i >= rows ||
      j >= cols ||
      visited[i][j] === true ||
      grid[i][j] === "0"
    )
      return;
    visited[i][j] = true;
    this.dfs(i - 1, j, rows, cols, visited, grid);
    this.dfs(i, j + 1, rows, cols, visited, grid);
    this.dfs(i, j - 1, rows, cols, visited, grid);
    this.dfs(i + 1, j, rows, cols, visited, grid);
  }
}