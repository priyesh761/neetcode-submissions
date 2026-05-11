/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0, r=mountainArr.length()-1, ans=-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            int lf = mountainArr.get(m-1);
            int curr = mountainArr.get(m);
            int rt = mountainArr.get(m+1);
            if(lf<curr && curr<rt) {
                l=m+1;
            } else if (lf>curr && curr> rt) {
                r = m-1;
            } else {
                ans = m;
                break;
            }
        }
        l=0;
        r=ans;
        int ind = bs(mountainArr, target, l, r, false);
        if(ind!=-1) return ind;

        return bs(mountainArr, target, r, mountainArr.length()-1, true);
    }

    private int bs(MountainArray ma, int target, int  l, int r, boolean gr) {
        while(l<=r) {
            int m = l + (r-l)/2;
            int val = ma.get(m);
            if((!gr && val<target)||(gr && val>target)) {
                l=m+1;
            } else if((!gr && val>target) || (gr && val<target)) {
                r=m-1;
            } else {
                return m;
            }
        }
        return -1;
    }
}