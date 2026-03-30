class Solution {
    private:
    int calc(vector<int>& dp, string& s, int i=0) {
        if(i==s.length()) return 1;
        if(dp[i]!=-1) return dp[i];

        int ans=0;
        if(s[i]=='0') return 0;
        else {
            ans += calc(dp, s, i+1);
            if(i+1!=s.length()) {
                bool isTwenties = s[i]=='2' && s[i+1]>='0'&& s[i+1]<='6';
                bool isTens = s[i]=='1';
                if(isTens || isTwenties) {
                    ans += calc(dp, s, i+2);
                }
            }
        }
        return dp[i]=ans;
    }
public:
    int numDecodings(string s) {
        vector<int> dp(s.size(), -1);
        return calc(dp, s);
    }
};
