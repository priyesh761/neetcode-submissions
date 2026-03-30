class Solution {
public:
    int numDecodings(string s, int i=0) {
        if(i==s.length()) return 1;

        int ans=0;
        if(s[i]=='0') return 0;
        else {
            ans += numDecodings(s, i+1);
            if(i+1!=s.length()) {
                bool isTwenties = s[i]=='2' && s[i+1]>='0'&& s[i+1]<='6';
                bool isTens = s[i]=='1';
                if(isTens || isTwenties) {
                    ans += numDecodings(s, i+2);
                }
            }
        }
        return ans;
    }
};
