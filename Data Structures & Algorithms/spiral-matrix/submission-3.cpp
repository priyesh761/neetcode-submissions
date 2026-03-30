class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int n = matrix.size()*matrix[0].size();
        for(int i=0;i<=(int)max(matrix.size(), matrix[0].size())/2;i++) {
            for(int j=i;res.size()<n&&j<(int)matrix[0].size()-i-1;j++) {
                cout<<i<<'-'<<j<<' ';
                res.push_back(matrix[i][j]);
            }
            cout<<'\n';
            for(int j=i;res.size()<n&&j<(int)matrix.size()-i-1;j++) {
                cout<<j<<'='<<matrix[0].size()-1-i<<' ';
                res.push_back(matrix[j][matrix[0].size()-1-i]);
            }
            cout<<'\n';
            for(int j=(int)matrix[0].size()-i-1;res.size()<n&&j>i;j--) {
                cout<<matrix.size()-1-i<<'_'<<j<<' ';
                res.push_back(matrix[matrix.size()-i-1][j]);
            }
            cout<<'\n';
            for(int j=(int)matrix.size()-i-1;res.size()<n&&j>i;j--) {
                cout<<j<<'+'<<i<<' ';
                res.push_back(matrix[j][i]);
            }
            cout<<'\n';
        }
        if(res.size()<n) res.push_back(matrix[matrix.size()/2][matrix.size()/2]);
        return res;
    }
};
