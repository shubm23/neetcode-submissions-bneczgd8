class Solution {
    private int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0;i < rows;i++){
            if(board[i][0] == 'O'){
                solveDfs(i,0,board);
            }
            
            if(board[i][cols - 1] == 'O'){
                solveDfs(i,cols - 1,board);
            }
        }
        
        for(int j = 0;j < cols;j++){
            if(board[0][j] == 'O'){
                solveDfs(0,j,board);
            }
            
            if(board[rows - 1][j] == 'O'){
                solveDfs(rows - 1,j,board);
            } 
        }
        
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void solveDfs(int r,int c,char[][] board){
        if(r < 0||c < 0||r >= board.length||c >= board[0].length || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for(int[] dir : directions){
            int rd = r + dir[0] , cd = c + dir[1];
            solveDfs(rd,cd,board);
        }
    }
}
