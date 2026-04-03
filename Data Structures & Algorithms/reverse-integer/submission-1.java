class Solution {
    public int reverse(int x) {
        if(x==0) return 0;
        StringBuilder sb1 = new StringBuilder(String.valueOf(Integer.MAX_VALUE));
        StringBuilder sb2 = new StringBuilder(String.valueOf(Integer.MIN_VALUE));
        
        StringBuilder sb = new StringBuilder();
        boolean pos = x>0;
        if(!pos) sb.append('-');
        while(x!=0) {
            int n = x%10;
            x/=10;
            sb.append(Math.abs(n));
        }
        if(pos) {
            if(sb.length()<sb1.length()||sb.compareTo(sb1)<=0) {
                return new Integer(sb.toString());
            } else {
                return 0;
            }
        }
        if(!pos) {
            if(sb.length()<sb2.length()||sb.compareTo(sb2)<=0) {
                return new Integer(sb.toString());
            } else {
                return 0;
            }
        }
        return 0;
    }
}
