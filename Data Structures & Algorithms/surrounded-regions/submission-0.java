class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            if(board[i][0]=='O'){
                mark(board, vis, i, 0);
            }
            if(board[i][m-1]=='O') {
                mark(board, vis, i, m-1);
            }
        }
        for(int j=0;j<m;j++) {
            if(board[0][j]=='O'){
                mark(board, vis, 0, j);
            }
            if(board[n-1][j]=='O') {
                mark(board, vis, n-1, j);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='O'&&vis[i][j]==false) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void mark(char[][] board, boolean[][] vis, int x, int y) {
        if(board[x][y]=='X' || vis[x][y]==true) return;
        vis[x][y]=true;

        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                mark(board, vis, nx, ny);
            }
        }
    }
}
