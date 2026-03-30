class Solution {
    public boolean checkValidString(String s) {
        int mn=0, mx=0;

        for(char c: s.toCharArray()) {
            if(c=='(') {
                mn++;
                mx++;
            } else if(c==')') {
                mn--;
                mx--;
            } else {
                mn--;
                mx++;
            }
            if(mx<0) return false;
            mn = Math.max(mn, 0);
        }
        return mn==0;
    }
}
