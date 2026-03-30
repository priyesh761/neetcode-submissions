class Solution {
    void getPalindrome(string& s,
        vector<vector<bool>>& isPal,
        vector<string>& tRes,
        vector<vector<string>>& res,
        int ind) {
            if(ind==s.length()) {
                res.push_back(tRes);
                return;
            }

            for(int i=ind;i<s.length();i++) {
                if(isPal[ind][i]) {
                    tRes.push_back(s.substr(ind, i-ind+1));
                    getPalindrome(s, isPal, tRes, res, i+1);
                    tRes.pop_back();
                }
            }
        }
public:
    vector<vector<string>> partition(string s) {
        vector<vector<bool>> isPal(s.length(), vector<bool>(s.length()));
        for(int i=0;i<s.length();i++) {
            int j=0;
            while(i-j>=0&&i+j<s.length()&&s[i-j]==s[i+j]) {
                isPal[i-j][i+j] = true;
                j++;
            }
            j=0;
            while(i-j-1>=0&&i+j<s.length()&&s[i-j-1]==s[i+j]) {
                isPal[i-j-1][i+j] = true;
                j++;
            }
        }

        vector<vector<string>> res;
        vector<string> tmp;
        getPalindrome(s, isPal, tmp, res, 0);

        return res;
    }
};
