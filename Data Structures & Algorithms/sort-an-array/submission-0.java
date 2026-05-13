class Solution {
    private void mergesort(int[] nums, int l, int r) {
        if(l+1>=r) return;
        int m = l + (r-l)/2;
        mergesort(nums, l, m);
        mergesort(nums, m, r);
        merge(nums, l, m, r); 
    }
    private void merge(int[] nums, int l, int m, int r) {
        int[] cp = new int[r-l];
        int i=l, j=m, k=0;
        while(i<m&&j<r){
            if(nums[i]<nums[j]) {
                cp[k] = nums[i];
                i++;
            } else {
                cp[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i<m) {
            cp[k] = nums[i];
            i++;
            k++;
        }
        while(j<r) {
            cp[k] = nums[j];
            j++;
            k++;
        }
        for(int itr=l;itr<r;itr++) {
            nums[itr] = cp[itr-l];
        }
    }
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length);
        return nums;
    }
}