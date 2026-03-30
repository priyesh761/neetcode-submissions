class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp(s.length());
        for(int i=0;i<s.length();i++) {
            for(auto& word: wordDict) {
                if(i==0 || dp[i-1]==true) {
                    if(i+word.length()-1<s.length()) {
                        if(s.substr(i, word.length())==word) {
                            dp[i+word.length()-1] = (i==0 ? true: dp[i-1]);
                        }
                    }
                }
            }
        }
        return dp.back();
    }
};
