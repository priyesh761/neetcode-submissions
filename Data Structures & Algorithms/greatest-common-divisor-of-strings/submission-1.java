class Solution {
    private int gcd(int a, int b) {
        return a%b==0 ? b : gcd(b, a%b);
    }

    public String gcdOfStrings(String str1, String str2) {
        String str = str1+str2;
        String rev = str2+str1;
        if(!str.equals(rev)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));    
    }
}