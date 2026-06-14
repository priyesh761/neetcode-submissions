class Solution {
    public int candy(int[] ratings) {
        int[] prefix = new int[ratings.length];
        int[] suffix = new int[ratings.length];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);

        for(int i=1;i<ratings.length;i++) {
            if(ratings[i]>ratings[i-1]) {
                prefix[i] = prefix[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1]) {
                suffix[i] = suffix[i+1]+1;
            }
        }
        int ans = 0;
        for(int i=0;i<ratings.length;i++) {
            ans += Math.max(prefix[i], suffix[i]);
        }
        return ans;
    }
}