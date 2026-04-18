class Solution {
    private boolean match(int[] matchstick, int ind, long t1, long t2, long t3, long t4) {
        if(ind==matchstick.length) {
            return t1==0 && t2==0 && t3==0 && t4==0;
        }
        if(t1<0 || t2<0 || t3<0 || t4<0) return false;
        return match(matchstick, ind+1, t1-matchstick[ind], t2, t3, t4)
            || match(matchstick, ind+1, t1, t2-matchstick[ind], t3, t4)
            || match(matchstick, ind+1, t1, t2, t3-matchstick[ind], t4)
            || match(matchstick, ind+1, t1, t2, t3, t4-matchstick[ind]);
    }
    public boolean makesquare(int[] matchsticks) {
        long sum=0;
        for(int stick: matchsticks) {
            sum += stick;
        }
        if(sum%4!=0) return false;
        long target = sum/4;

        return match(matchsticks, 0, target, target, target, target);
    }
}