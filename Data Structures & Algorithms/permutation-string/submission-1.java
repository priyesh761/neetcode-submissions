class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s1.toCharArray()) {
            mp.compute(c, (k,v)-> v==null?1:v+1);
        }
        
        char[] cs2 = s2.toCharArray();
        int n1 = s1.length();
        for(int i=0;i<cs2.length;i++) {
            mp.compute(cs2[i], (k,v)-> v==null?-1:v-1);
            if(mp.get(cs2[i])==0) mp.remove(cs2[i]);
            
            if(i>=n1) {
                mp.compute(cs2[i-n1], (k,v)->v==null?1:v+1);
                if(mp.get(cs2[i-n1])==0) mp.remove(cs2[i-n1]);
            }
            if(mp.size()==0) return true;
        }
        return false;
    }
}
