class Solution {
  /**
   * @param {number[][]} grid
   * @return {number}
   */
  orangesRotting(grid) {
    /**
     * 1. Push the Coordinates and time
     * 2. do bfs to do level order search
     * 3. Search for the any oranges remains
     */
    let ans = 0;
    const rows = grid.length;
    const cols = grid[0].length;
    const visited = Array.from({ length: rows }, () =>
      new Array(cols).fill(false),
    );
    const queue = [];

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (grid[i][j] === 2) {
          queue.push([[i, j], 0]);
          visited[i][j] = true;
        }
      }
    }

    while (queue.length > 0) {
      const coord = queue.shift();
      const i = coord[0][0];
      const j = coord[0][1];
      const time = coord[1];
      ans = Math.max(ans, time);

      if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] === 1) {
        queue.push([[i - 1, j], time + 1]);
        visited[i - 1][j] = true;
      }

      if (i + 1 < rows && !visited[i + 1][j] && grid[i + 1][j] === 1) {
        queue.push([[i + 1, j], time + 1]);
        visited[i + 1][j] = true;
      }

      if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] === 1) {
        queue.push([[i,j - 1], time + 1]);
        visited[i][j - 1] = true;
      }

      if (j + 1 < cols && !visited[i][j + 1] && grid[i][j + 1] === 1) {
        queue.push([[i,j + 1], time + 1]);
        visited[i][j + 1] = true;
      }
    }

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (grid[i][j] === 1 && !visited[i][j]) return -1;
      }
    }

    return ans;
  }
}
