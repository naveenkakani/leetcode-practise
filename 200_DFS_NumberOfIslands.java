class Solution {
    public void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int columns = grid[0].length;
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == '1') count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }
}
