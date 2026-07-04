class Solution {
    public long minEnd(int n, int x) {
        long[] xbit = new long[63];
        long[] nbit = new long[63];
        for(int i=0; i<63; i++) {
            xbit[i] = (((long)x&(1l<<i))>0)?1:0;
            nbit[i] = ((((long)n-1)&(1l<<i))>0)?1:0;
        }
        long res = 0;
        int cnt=0;
        for(int i=0;i<63;i++) {
            if(xbit[i]==0) {
                res |= (nbit[cnt]<<i);
                cnt++;
            } else {
                res |= (1L<<i);
            }
            System.out.println(""+res+" "+xbit[i]+" "+nbit[cnt]+" "+cnt);
        }
        return res;
    }
}