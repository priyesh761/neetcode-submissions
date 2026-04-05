class Solution {
    int find(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 && nums2.length==0) return 0;
        int l=Integer.MAX_VALUE, r=Integer.MIN_VALUE;
        for(int v: nums1) {
            l=Math.min(l, v);
            r=Math.max(r, v);
        }
        for(int v: nums2) {
            l=Math.min(l, v);
            r=Math.max(r, v);
        }

        int ans=0;
        while(l<=r) {
            int m = l + (r-l)/2;
            int v1 = Arrays.binarySearch(nums1, m);
            int v2 = Arrays.binarySearch(nums2, m);
            v1 = Math.abs(v1+1);
            v2 = Math.abs(v2+1);
            if(v1+v2<k) {
                l=m+1;
            } else {
                r=m-1;
                ans=m;
            }
        }
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if((m+n)%2==1) {
            return find(nums1, nums2, (n+m)/2+1);
        }

        return (find(nums1, nums2, (n+m)/2)+find(nums1, nums2, (n+m)/2+1))/2.0;
    }
}
