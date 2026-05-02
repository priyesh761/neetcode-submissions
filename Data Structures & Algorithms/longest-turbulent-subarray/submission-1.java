class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int cnt=1, sign=0, mx=1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]==arr[i-1]) {
                sign = 0;
                cnt=1;
            } else if (arr[i]>arr[i-1]) {
                cnt = (sign!=1) ? cnt+1: 2;
                sign = 1;
            } else {
                cnt = (sign!=-1) ? cnt+1: 2;
                sign = -1;
            }
            mx = Math.max(cnt, mx);
        }
        return mx;
    }
}