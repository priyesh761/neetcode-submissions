class Solution {
    public int getMSB(int n) {
        for(int i=31;i>=0;i--) {
            if((n>>i)!=0) return i;
        }
        return 0;
    }
    public int rangeBitwiseAnd(int left, int right) {
        int lmsb = getMSB(left);
        int rmsb = getMSB(right);
        if(lmsb==rmsb) {
            int val=0;
            for(int i=lmsb;i>=0;i--) {
                if((left &(1<<i))==(right &(1<<i))) {
                    val|=(left&(1<<i));
                } else {
                    break;
                }
            }
            return val;
        }
        return 0;
    }
}