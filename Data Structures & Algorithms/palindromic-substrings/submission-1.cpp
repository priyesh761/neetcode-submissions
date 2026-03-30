class Solution {
public:
    int countSubstrings(string s) {
        if(s=="") return 0;
        int cnt=1;
        for(int i=0;i<s.length()-1;i++){
            for(int j=0; i-j>=0 && i+j<s.length() && s[i-j]==s[i+j]; j++){
                cnt++;
            }
            for(int j=0; i-j>=0 && i+j+1<s.length() && s[i-j]==s[i+j+1]; j++){
                cnt++;
            }
        }
        return cnt;
    }
};
