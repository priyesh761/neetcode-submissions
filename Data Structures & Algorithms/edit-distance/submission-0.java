class Solution {
    int md(String w1, String w2, int[][] dp, int x, int y) {
        if(x==w1.length() || y==w2.length())
            return Math.max(w1.length()-x, w2.length()-y);
        if(dp[x][y]!=-1) return dp[x][y];

        if(w1.charAt(x)==w2.charAt(y)) {
            return dp[x][y] = md(w1, w2, dp, x+1, y+1);
        }

        return dp[x][y]=1+Collections.min(List.of(
            md(w1, w2, dp, x, y+1),
            md(w1, w2, dp, x+1, y),
            md(w1, w2, dp, x+1, y+1)));
    }
    public int minDistance(String word1, String word2) {
       int[][] dp = new int[word1.length()][word2.length()];
       for(int[] row: dp) {
        Arrays.fill(row, -1);
       }
       return md(word1, word2, dp, 0, 0);
    }
}
