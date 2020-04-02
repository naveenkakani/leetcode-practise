class Solution {
    
    private void dfs(char[][] board, int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'X' || board[r][c] == 'N') return;
        
        if(board[r][c] == 'O') board[r][c] = 'N';
        
        dfs(board, r, c-1);
        dfs(board, r, c+1);
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        
    }
    /* TC : O(M X N) */
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows <= 1) return;
        int columns = board[0].length;
        /* DO DFS  */
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[rows-i-1][columns-1] == 'O') dfs(board, rows-i-1, columns-1);
        }
        for(int j = 0; j < columns; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[rows-1][columns-j-1] == 'O') dfs(board, rows-1, columns-j-1);
        }
        
        /* Replace */
        for(int i = 0; i <  rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'N') board[i][j] = 'O';
            }
            System.out.println();
        }
        
    }
}
