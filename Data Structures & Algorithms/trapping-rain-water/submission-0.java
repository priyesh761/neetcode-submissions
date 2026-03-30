class Solution {
    public int trap(int[] heights) {
        List<Integer> lmax = new ArrayList<>(Collections.nCopies(heights.length,0));
        List<Integer> rmax = new ArrayList<>(Collections.nCopies(heights.length,heights.length-1));

        int mx = 0;
        for(int i=0;i<heights.length;i++) {
            if(heights[mx] <= heights[i]){
                mx = i;
            }
            lmax.set(i, mx);
        }
        mx = heights.length-1;
        for(int i=heights.length-1;i>=0;i--) {
            if(heights[mx] <= heights[i]){
                mx = i;
            }
            rmax.set(i, mx);
        }

        int curr=0;
        for(int i=0;i<heights.length;i++) {
            curr+= Math.min(heights[lmax.get(i)], heights[rmax.get(i)]) - heights[i];
            //System.out.println(""+i+" "+curr+" "+mx+" "+lmax.get(i)+" "+rmax.get(i));
        }
        return curr;
    }
}
