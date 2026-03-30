class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int n = matrix.size()*matrix[0].size();
        for(int i=0;i<=(int)max(matrix.size(), matrix[0].size())/2;i++) {
            for(int j=i;res.size()<n&&j<(int)matrix[0].size()-i-1;j++) {
                res.push_back(matrix[i][j]);
            }
            for(int j=i;res.size()<n&&j<(int)matrix.size()-i-1;j++) {
                res.push_back(matrix[j][matrix[0].size()-1-i]);
            }
            for(int j=(int)matrix[0].size()-i-1;res.size()<n&&j>i;j--) {
                res.push_back(matrix[matrix.size()-i-1][j]);
            }
            for(int j=(int)matrix.size()-i-1;res.size()<n&&j>i;j--) {
                res.push_back(matrix[j][i]);
            }
        }
        if(res.size()<n) res.push_back(matrix[matrix.size()/2][matrix.size()/2]);
        return res;
    }
};
