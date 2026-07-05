class Solution {
    private boolean isPal(String s, int i, int j) {
        if(i>=j) return true;
        return s.charAt(i)==s.charAt(j) && isPal(s, i+1, j-1);
    }
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPal(s, i, j-1) || isPal(s, i+1, j);
            }
        }
        return true;
    }
}