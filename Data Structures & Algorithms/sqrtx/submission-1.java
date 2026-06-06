class Solution {
    public int mySqrt(int x) {
        long l=0, r=x, ans=0;
        while(l<=r){
            long m = l+ (r-l)/2;
            if(m*m<=x){
                l=m+1;
                ans=m;
            } else {
                r=m-1;
            }
        }
        return (int)ans;
    }
}