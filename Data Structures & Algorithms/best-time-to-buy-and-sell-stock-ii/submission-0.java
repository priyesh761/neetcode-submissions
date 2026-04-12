class Solution {
    public int maxProfit(int[] prices) {
        int curr = prices[0];
        int prof = 0;
        for(int i: prices) {
            if(i>=curr) {
                prof += i-curr;
            }
            curr=i;
        }
        return prof;
    }
}