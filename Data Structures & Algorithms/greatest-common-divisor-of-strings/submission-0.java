class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int mn = Math.min(str1.length(), str2.length());
        for(int i=mn;i>0;i--) {
            if(str1.length()%i!=0||str2.length()%i!=0) continue;
            boolean isGCD = true;
            for(int j=0;j<str1.length();j++) {
                if(str1.charAt(j)!=str1.charAt(j%i) || str1.charAt(j)!=str2.charAt(j%i)) {
                    isGCD = false;
                    break;
                }
            }
            for(int j=0;j<str2.length();j++) {
                if(str2.charAt(j)!=str2.charAt(j%i) || str2.charAt(j)!=str1.charAt(j%i)) {
                    isGCD = false;
                    break;
                }
            }
            if(isGCD) {
                return str1.substring(0, i);
            }
        }
        return "";    
    }
}