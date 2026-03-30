class Solution {
    bool check(string& s1, string& s2, string& s3) {
        int i=0,j=0,k=0;
        while(k<s3.size()&&(i<s1.size()||j<s2.size())) {
            int tmp = k;
            while(k<s3.size()&&i<s1.size()&&s3[k]==s1[i]) {
                k++;
                i++;
            }
            cout<<i<<'-'<<k<<'\n';
            if(tmp==k) return false;
            if(k==s3.size()) break;
            tmp=k;
            while(k<s3.size()&&j<s2.size()&&s3[k]==s2[j]) {
                k++;
                j++;
            }
            if(tmp==k) return false;
            cout<<j<<'='<<k<<'\n';
        }
        return i==s1.size()&&j==s2.size()&&k==s3.size();
    }
public:
    bool isInterleave(string s1, string s2, string s3) {
        bool ans = false;
        ans = ans || (s1[0]==s3[0]&&check(s1, s2, s3));
        ans = ans || (s2[0]==s3[0]&&check(s2, s1, s3));
        return ans;
    }
};
