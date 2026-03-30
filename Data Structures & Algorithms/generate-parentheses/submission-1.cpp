class Solution {
    void generate(vector<string>& res, string& s, int st, int en, int rem) {
        if(rem==0) {
            res.push_back(s);
            return;
        }
        if(st<rem+en) {
            s.push_back('(');
            generate(res, s, st+1, en, rem-1);
            s.pop_back();
        }
        if(en+1<=st) {
            s.push_back(')');
            generate(res, s, st, en+1, rem-1);
            s.pop_back();
        }
        return;
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string s;
        generate(res, s, 0, 0, 2*n);
        return res;
    }
};
