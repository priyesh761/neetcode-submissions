class Solution {
    int[][] dv = {
        {1,0},
        {-1,0},
        {0,-1},
        {0,1}
    };
    private boolean exist(char[][] board, boolean[][] vis, String word, int x, int y, int ind) {
        if(vis[x][y]) return false;
        if(board[x][y]!=word.charAt(ind)) return false;
        if(ind==word.length()-1) return true;
        vis[x][y] = true;
        boolean valid = false;
        for(int[] dir: dv) {
            int nx = x+dir[0];
            int ny = y+dir[1];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length) {
                valid = valid || exist(board, vis, word, nx, ny, ind+1);
            }
        }
        vis[x][y] = false;
        return valid;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(exist(board, vis, word, i, j, 0)) return true;
            }
        }
        return false;
    }
}
