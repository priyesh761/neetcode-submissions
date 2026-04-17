class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=0;i<s.length();i++) {
            if(dp[i]==false) continue;
            for(int j=i+minJump;j<=Math.min(i+maxJump, s.length()-1);j++) {
                dp[j] = s.charAt(j)=='0';
            }
        }
        return dp[s.length()-1];
    }
}