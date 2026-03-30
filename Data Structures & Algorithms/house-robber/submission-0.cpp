class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        int robWithLast=0, robWithoutLast=0, mx=0;
        for(int i=0;i<size;i++) {
            int currentMax = max(robWithLast, robWithoutLast + nums[i]);
            robWithoutLast = robWithLast;
            robWithLast = currentMax;
            mx = max(mx, currentMax);
        }
        return mx;
    }
};
