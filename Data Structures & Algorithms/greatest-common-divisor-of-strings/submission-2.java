class Solution {
    private int gcd(int a, int b) {
        return a%b==0 ? b : gcd(b, a%b);
    }

    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)==false) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));    
    }
}