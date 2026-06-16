class Solution {
    public List<Integer> majorityElement(int[] nums) {

      int n1=Integer.MIN_VALUE, n2=Integer.MIN_VALUE, v1=0, v2=0;

      for(int i: nums) {
        if(n1==i) {
            v1++;
        } else if(n2==i) {
            v2++;
        } else if(v1==0) {
            n1 = i;
            v1 = 1;
        } else if(v2==0) {
            n2 = i;
            v2 = 1;
        } else {
            v1--;
            v2--;
        }
      }

      int cnt1=0, cnt2=0;
      for(int i: nums) {
        if(i==n1) cnt1++;
        if(i==n2) cnt2++;
      }
      int nm = nums.length/3;
      List<Integer> ar = new ArrayList<>();
      if(cnt1>nm) ar.add(n1);
      if(cnt2>nm) ar.add(n2);
      return ar;
    }
}