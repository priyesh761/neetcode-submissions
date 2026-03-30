class Solution {
    private double pow(double x, int n) {
        if(n==0) return 1;
        return x*myPow(x, n-1);
    }
    public double myPow(double x, int n) {
        int ab = Math.abs(n);
        double pw = 1;
        if(n>0) pw *= pow(x, ab);
        else pw /= pow(x, ab);
        return pw;
    }
}