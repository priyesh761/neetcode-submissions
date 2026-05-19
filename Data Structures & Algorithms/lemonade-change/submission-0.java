class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fv=0, tn=0;
        for(int i:bills) {
            if(i==5) {
                fv++;
            } else if(i==10) {
                if(fv==0) return false;
                fv--;
                tn++;
            } else if(i==20) {
                if(tn>0&&fv>0) {
                    tn--;
                    fv--;
                } else if(fv>=3) {
                    fv-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}