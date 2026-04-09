class Edge {
    int time;
    int row;
    int col;
    
    Edge(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Edge>queue = new ArrayDeque<>();
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int minTime  = 0;
        
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 2){
                    queue.add(new Edge(i,j,0));
                    visited[i][j] = false;
                }
            }
        }
        
        
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            int time = edge.time,i = edge.row ,j = edge.col;
            minTime = Math.max(minTime,time);
            if(i - 1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1){
                queue.add(new Edge(i-1,j,time+1));
                visited[i-1][j] = true;
            }
            if(i + 1 < row && !visited[i+1][j] && grid[i+1][j] == 1){
                queue.add(new Edge(i+1,j,time+1));
                visited[i+1][j] = true;
            }
            if(j - 1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1){
                queue.add(new Edge(i,j-1,time+1));
                visited[i][j-1] = true;
            }
            if(j + 1 < col && !visited[i][j+1] && grid[i][j+1] == 1){
                queue.add(new Edge(i,j+1,time+1));
                visited[i][j + 1] = true;
            }
        }

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        
        return minTime;
    }
}
