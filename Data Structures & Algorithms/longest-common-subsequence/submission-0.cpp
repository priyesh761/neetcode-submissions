class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n1=text1.length(), n2=text2.length();

        vector<vector<int>> sub(n1, vector<int>(n2));
        int mx=0;
        for(int i=0;i<n1;i++) {
            for(int j=0;j<n2;j++) {
                sub[i][j]=(text1[i]==text2[j]);
                if(i!=0 && j!=0) sub[i][j]+=sub[i-1][j-1];
                if(i!=0) sub[i][j] = max(sub[i][j], sub[i-1][j]);
                if(j!=0) sub[i][j] = max(sub[i][j], sub[i][j-1]);
                mx = max(mx, sub[i][j]);
            }
        }
        return mx;
    }
};
