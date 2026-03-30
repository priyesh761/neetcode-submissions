class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int nm1 = (int)(num1.charAt(i)-'0');
                int nm2 = (int)(num2.charAt(j)-'0');
                int prod =  nm2*nm1 + res[i+j+1];
                System.out.println(""+nm1+" "+nm2+" "+prod);
                res[i+j+1] = prod%10;
                res[i+j] += prod/10;
                for(int k:res) System.out.print(""+k+" ");
                System.out.println("");
            }
        }

        StringBuilder s3 = new StringBuilder();
        for(int i: res) {
            if(s3.isEmpty()&& i==0) continue;
            s3.append((char)('0'+i));
        }
        return s3.toString();
    }
}
