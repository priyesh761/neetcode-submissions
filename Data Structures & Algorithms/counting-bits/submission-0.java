class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];

        for(int i=0;i<=n;i++) {
            int cnt=0;
            for(int j=0; j<31; j++) {
                cnt += ((i>>j) & 1);
            }
            bits[i] = cnt;
        }
        return bits;
    }
}
