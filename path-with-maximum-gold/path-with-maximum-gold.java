class Solution {
  public int getMaximumGold(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=0 ; i<row ; ++i){
            for(int j=0 ; j<col ; ++j){
                
                if(grid[i][j] != 0){
                    int small_ans = helper(grid, i, j, row, col);
                    ans = Math.max(small_ans, ans);
                }
            }
        }
        
        return ans;
    }
    
    private int helper(int[][] grid, int i, int j, int row, int col){
        
        if(i < 0 || i >= row || j < 0 || j >= col)
            return 0;
        
        if(grid[i][j] == 0)
            return 0;
                
        int val = grid[i][j];
        grid[i][j] = 0;
        int right = val + helper(grid, i, j+1, row, col);
        int left = val + helper(grid, i, j-1, row, col);
        int top = val + helper(grid, i-1, j, row, col);
        int bottom = val + helper(grid, i+1, j, row, col);
        
        grid[i][j] = val;
        return Math.max(Math.max(top, bottom), Math.max(left, right));
     }
}