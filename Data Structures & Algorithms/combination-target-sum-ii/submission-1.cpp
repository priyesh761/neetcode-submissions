class Solution {
    void fill(
        vector<int>& candidates,
        vector<vector<int>>& res,
        vector<int>& combination,
        int ind,
        int target
    ) {
        if(target==0) {
            res.push_back(combination);
            return;
        }

        int i=ind;
        while(i<candidates.size() && target>=candidates[i]) {
            combination.push_back(candidates[i]);
            fill(candidates, res, combination, i+1, target-candidates[i]);
            combination.pop_back();
            int j=i;
            while(i<candidates.size() && candidates[i]==candidates[j]) i++;
        }
    }
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());

        vector<vector<int>> res;
        vector<int> combination;
        fill(candidates, res, combination, 0, target);
        return res;
    }
};
