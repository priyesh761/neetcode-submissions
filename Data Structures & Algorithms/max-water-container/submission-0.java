class Solution {
    public int maxArea(int[] heights) {
        int left=0, right=heights.length-1, mx=0;

        while(left<right) {
            int size = Math.min(heights[left], heights[right]) * (right-left);
            mx = Math.max(mx, size);
            if(heights[left]<heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return mx;
    }
}
