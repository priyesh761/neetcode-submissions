class Solution {
    int calc(int[] weights, int mx) {
        int count=1, curr=0;
        for(int weight: weights) {
            if(curr+weight<= mx) {
                curr+=weight;
            } else {
                count++;
                curr = weight;
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0, mx=-1;
        for(int weight: weights) {
            sum += weight;
            mx = Math.max(mx, weight);
        }
        int l = mx, r = sum, res=-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            int req = calc(weights, m);
            if(req<=days) {
                res = m;
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return res;
    }
}