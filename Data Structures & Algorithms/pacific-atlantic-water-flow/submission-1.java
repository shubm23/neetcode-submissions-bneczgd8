class Solution {
    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];


        for (int i = 0; i < col; i++) {
            pacificAtlanticDfs(0, i, pac, heights[0][i], heights);
            pacificAtlanticDfs(row - 1, i, atl, heights[row - 1][i], heights);
        }

        for (int i = 0; i < row; i++) {
            pacificAtlanticDfs(i, 0, pac, heights[i][0], heights);
            pacificAtlanticDfs(i, col - 1, atl, heights[i][col - 1], heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void pacificAtlanticDfs(int r, int c, boolean[][] visited, int prevHeights, int[][] heights) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeights)
            return;
        visited[r][c] = true;
        for (int[] dir : direction) {
            int nr = r + dir[0], nc = c + dir[1];
            pacificAtlanticDfs(nr, nc, visited, heights[r][c], heights);
        }
    }
}
