class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int i: hand) {
            mp.compute(i, (k, v) -> v==null? 1: v+1);
        }

        int cnt=0;
        while(mp.isEmpty()==false) {
            int key = mp.firstKey();
            int val = mp.get(key);
            for(int i = key; i<key+groupSize; i++) {
                if(mp.containsKey(i)==false) return false;
                int nxtVal = mp.get(i);
                if(nxtVal<val) return false;
                if(nxtVal == val) mp.remove(i);
                else mp.put(i, nxtVal-val);
            }
            cnt++;
            if(cnt==10) break;
        }


        return true;
    }
}
