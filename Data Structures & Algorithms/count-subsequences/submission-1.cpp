class Solution {
public:
    int numDistinct(string s, string t) {
       vector<vector<int>> dp(t.length(), vector<int>(s.length()));

       for(int i=0;i<t.length();i++) {
            for(int j=0;j<s.length();j++) {
                if(j!=0) dp[i][j] += dp[i][j-1];
                dp[i][j] += (t[i]==s[j])*(i!=0&&j!=0? dp[i-1][j-1]:(i==0));
            }
       }

       return dp[t.length()-1][s.length()-1];
    }
};
