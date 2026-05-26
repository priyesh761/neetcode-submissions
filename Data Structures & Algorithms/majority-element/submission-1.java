class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0, val=-1;
        for(int i=0;i<nums.length;i++) {
            if(val==nums[i]) {
                cnt++;
            } else {
                cnt--;
                if(cnt<=0) {
                    val = nums[i];
                    cnt = 1;
                }
            }
        }
        return val;
    }
}