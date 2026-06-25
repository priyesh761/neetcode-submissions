class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int mn=Integer.MAX_VALUE, vl=0, st=0;
        for(int i=0;i<k;i++) {
            vl+=Math.abs(arr[i]-x);
        }
        mn = vl;
        for(int i=k;i<arr.length;i++) {
            vl-=Math.abs(arr[i-k]-x);
            vl+=Math.abs(arr[i]-x);
            if(vl<mn) {
                mn = vl;
                st = i-k+1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=st;i<st+k;i++) {
            res.add(arr[i]);
        }
        return res;
    }
}