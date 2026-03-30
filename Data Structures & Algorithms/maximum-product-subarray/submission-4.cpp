class Solution {
public:
    int maxProduct(vector<int>& nums) {
        vector<pair<int,int>> products(nums.size());
        int mx = *max_element(nums.begin(), nums.end());
        
        for(int i=0;i<nums.size();i++) {
            int lastPos, lastNeg;
            tie(lastPos, lastNeg) = i==0 ?
                pair<int,int>(INT_MAX,INT_MIN) :
                products[i-1];

                if(nums[i]>=0) {
                    products[i].first = lastPos==INT_MAX?
                        nums[i]:
                        max(nums[i], nums[i]*lastPos);
                    products[i].second = lastNeg==INT_MIN?
                        INT_MIN:
                        min(nums[i], nums[i]*lastNeg);
                } else {
                    products[i].first = lastNeg==INT_MIN?
                        INT_MIN:
                        max(nums[i], nums[i]*lastNeg);
                    products[i].second = lastPos==INT_MAX?
                        nums[i]:
                        min(nums[i], nums[i]*lastPos);
                }
                mx = max(products[i].first, mx);
        }
        return mx;
    }
};
