class Solution {
    private boolean match(String s, String p, Boolean[][] dp, int x, int y) {
        if(s.length()==x && p.length()==y) {
            return true;
        } else if(s.length()==x || p.length()==y) {
            return y+2==p.length() && p.charAt(y+1)=='*';
        } else if(dp[x][y]!=null) {
            return dp[x][y];
        }

        if (y+1<p.length() && p.charAt(y+1) == '*') {
            char c = p.charAt(y);
            boolean ans = match(s, p, dp, x, y+2);
            for(int k=0;(x+k<s.length())&&(c=='.'||s.charAt(x+k)==c);k++) {
                ans = ans || match(s, p, dp, x+k+1, y+2);
                System.out.println(""+(x+k)+" "+(y+2)+" "+ans);
            }
            return dp[x][y] = ans;
        } else if(p.charAt(y) == '.') {
            return dp[x][y]=match(s, p, dp, x+1, y+1);
        } else {
            return dp[x][y] = (s.charAt(x)==p.charAt(y)
                && match(s, p, dp, x+1, y+1));
        }

    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        for(Boolean[] row: dp) {
            Arrays.fill(row, null);
        }

        return match(s, p, dp, 0, 0);
    }
}
