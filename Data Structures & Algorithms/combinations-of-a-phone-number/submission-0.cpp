class Solution {
    string dtoc[9] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
public:
    vector<string> letterCombinations(string digits, int i=0) {
        if(i==digits.size()) return vector<string>();

        vector<string> nextCombinations = letterCombinations(digits, i+1);
        vector<string> res;
        for(char c: dtoc[digits[i]-'2']) {
            string curr;
            curr.push_back(c);
            if(nextCombinations.empty()) {
                res.push_back(curr);
            } else {
                for(auto& comb: nextCombinations) {
                    res.push_back(curr+comb);
                }
            }
        }
        return res;
    }
};
