class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> st;
        while(n>1 && st.count(n)==false) {
            st.insert(n);
            string str = to_string(n);
            n=0;
            for(auto i: str) {
                n+= (i-'0')*(i-'0');
            }
            if(st.count(n)) return false;
        }
        return true;
    }
};
