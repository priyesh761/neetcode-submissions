class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> left(n), right(n);
        int lft=1, rt=1;

        for(int i=0; i<nums.size(); i++) {
            lft *= nums[i];
            rt *= nums[n-1-i];
            left[i] = lft;
            right[n-1-i] = rt;
        }

        vector<int> opt;
        for(int i=0;i<n;i++) {
            int prd=1;
            prd *= i==0? 1: left[i-1];
            prd *= i==n-1? 1:right[i+1];
            opt.push_back(prd);
        }
        return opt;
    }
};
