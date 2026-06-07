class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

int p=0;
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==0) continue;
                for(int k=0; k<4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (x<0||x>=grid.length||y<0||y>=grid[0].length){
                        p++;
                    }
                    else if(grid[x][y]==0) p++;
                }
            }
        }
        return p;
    }
}