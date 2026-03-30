class Solution {
    int calcLength(string& s, int l, int r) {
        int len = 0;
        while(l>=0 && r<s.length() && s[l]==s[r]) {
            len = r-l+1;
            l--;
            r++;
        }
        return len;
    }
public:
    string longestPalindrome(string s) {
        int maxLen=0, st=0;
        for(int i=0; i<s.length();i++) {
            int palLength = calcLength(s, i, i);
            if(palLength> maxLen) {
                maxLen = palLength;
                st = i-palLength/2;
            }
            if(i+1<s.length()) {
                palLength = calcLength(s,i,i+1);
                if(palLength> maxLen) {
                    maxLen = palLength;
                    st = i-palLength/2+1;
                }
            }
        }
        return s.substr(st, maxLen);
    }
};
