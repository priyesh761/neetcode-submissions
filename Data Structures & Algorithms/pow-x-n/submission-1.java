class Solution {
    private double pow(double x, int n) {
        if(n==0) return 1;
        double val = myPow(x, n/2);
        val*= val;
        if(n%2==1) val*=x;
        return val;
    }
    public double myPow(double x, int n) {
        int ab = Math.abs(n);
        double pw = 1;
        if(n>0) pw *= pow(x, ab);
        else pw /= pow(x, ab);
        return pw;
    }
}