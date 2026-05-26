class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0, val=-1, i=0;
        while(i<nums.length) {
            int j=i, cntx=0;
            while(i<nums.length&&nums[i]==nums[j]) {
                cntx++;
                i++;
            }
            if(cntx>cnt) {
                cnt = cntx;
                val = nums[j];
            }
            i++;
        }
        return val;
    }
}