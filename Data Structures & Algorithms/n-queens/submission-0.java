class Solution {
    private boolean validate(char[][] grid, int x, int y, int dx, int dy) {
        int i=0;
        while(x+i*dx>=0 && x+i*dx<grid.length && y+i*dy>=0 && y+i*dy<grid[0].length) {
            if(grid[x+i*dx][y+i*dy]=='Q') return false;
            i++;
        }
        return true;
    }
    private void fill(List<List<String>> list, char[][] grid, int row) {
        if(row<0) {
            List<String> res = new ArrayList<>();
            for(char[] ch: grid) {
                res.add(new String(ch));
            }
            list.add(res);
            return;
        }

        for(int j=0; j<grid[0].length; j++) {
            boolean isVacant = validate(grid, row, j, 0, 1)
                && validate(grid, row, j, 0, -1)
                && validate(grid, row, j, 1, 0)
                && validate(grid, row, j, -1, 0)
                && validate(grid, row, j, 1, 1)
                && validate(grid, row, j, -1, -1)
                && validate(grid, row, j, 1, -1)
                && validate(grid, row, j, -1, 1);
            
            if(!isVacant) continue;
            grid[row][j] = 'Q';
            fill(list, grid, row-1);
            grid[row][j] = '.';
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(char[] row: grid) {
            Arrays.fill(row, '.');
        }
        fill(list, grid, n-1);
        return list;
    }
}
