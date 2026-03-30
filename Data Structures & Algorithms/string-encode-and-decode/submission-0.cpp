class Solution {
public:

    string encode(vector<string>& strs) {
        string res;
        for(auto &i: strs) {
            res += to_string(i.size())+ "#"+i;
        }
        return res;
    }

    vector<string> decode(string s) {
        int i=0;
        vector<string> list;
        while(i<s.size()) {
            string sz, decodedString;
            while(i<s.size() && s[i]!='#') {
                sz.push_back(s[i]);
                i++;
            }
            i++;
            int size = stoi(sz);
            while(size--) {
                decodedString.push_back(s[i]);
                i++;
            }
            list.push_back(decodedString);
        }
        return list;
    }
};
