class Solution {
    public String addBinary(String a, String b) {
        while(a.length()<b.length()) a = "0"+a;
        while(b.length()<a.length()) b = "0"+b;
        
        StringBuilder res = new StringBuilder();
        int carry=0;
        for(int i=a.length()-1;i>=0;i--) {
            int na = a.charAt(i)-'0';
            int nb = b.charAt(i)-'0';
            int r = na+nb+carry;
            carry = r/2;
            r = r%2;
            res.append(r);
        }
        if(carry>0) res.append(carry);
        res.reverse();
        return res.toString();
    }
}