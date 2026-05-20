class NumMatrix {
    int[][] calc;
    public NumMatrix(int[][] matrix) {
        calc = matrix;
        for(int i=0;i<calc.length;i++) {
            for(int j=1;j<calc[i].length;j++) {
                calc[i][j] += calc[i][j-1];
            }
        }

        for(int i=1;i<calc.length;i++) {
            for(int j=0;j<calc[i].length;j++) {
                calc[i][j] += calc[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = calc[row2][col2];
        if(col1>0) val -= calc[row2][col1-1];
        if(row1>0) val -= calc[row1-1][col2];
        if(row1>0&&col1>0) val += calc[row1-1][col1-1];
        return val;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */