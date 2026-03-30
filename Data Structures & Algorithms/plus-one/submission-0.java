class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if(carry==0) return digits;
        int[] ar = new int[digits.length+1];
        
        for(int i=0;i<digits.length;i++) {
            ar[i+1] = digits[i];
        }
        ar[0] = carry;
        return ar;
    }
}
