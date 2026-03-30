class Solution {
    public int getSum(int a, int b) {
        int c=0, ans=0;
        int v1[] = new int[]{0,0,1,1,0,0,1,1};
        int v2[] = new int[]{0,1,0,1,0,1,0,1};
        int ca[] = new int[]{0,0,0,0,1,1,1,1};
        int rs[] = new int[]{0,1,1,0,1,0,0,1};
        int rc[] = new int[]{0,0,0,1,0,1,1,1};
        for(int i=0;i<32;i++) {
            int b1 = ((a>>i)&1);
            int b2 = ((b>>i)&1);
            int b3=0;
            for(int j=0;j<8;j++){
                if(b1==v1[j] && b2==v2[j] && c==ca[j]) {
                    b3=rs[j];
                    c=rc[j];
                    break;
                }
            }
            ans |= (b3<<i);
        }

        return ans;
    }
}
