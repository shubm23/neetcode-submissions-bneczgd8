class Solution {
    private int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                visited[i][j] = false;
            }
        }
        
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea,maxAreaOfIslandDfs(i,j,row,col,visited,grid));
                }
            }
        }
        
        return maxArea;
    }
    
    private int maxAreaOfIslandDfs(int i,int j,int row,int col,boolean[][] visited,int[][] grid){
        
        if(i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || grid[i][j] == 0) return 0;
        visited[i][j] = true;
        int maxArea = 1;
        for(int[] dir : direction){
            int rowIdx = i + dir[0], colIdx = j + dir[1];
            maxArea += this.maxAreaOfIslandDfs(rowIdx,colIdx,row,col,visited,grid);
        }
        return maxArea;
    }
}
