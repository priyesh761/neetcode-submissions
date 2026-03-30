class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        Map<Character, Integer> mp = new HashMap();
        for(char c: t.toCharArray()) {
            mp.compute(c, (k,v)->v==null?-1:v-1);
        }
        int l=0, cnt=0, st=-1, len=s.length()+1;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(mp.containsKey(c)==false) continue;

            int val = mp.compute(c, (k,v)-> v+1);
            if(val==0) cnt++;

            while(l<=i) {
                if(mp.containsKey(s.charAt(l))==false){
                    l++;
                    continue;
                }
                int count = mp.get(s.charAt(l));
                if(count<=0) break;
                mp.put(s.charAt(l), count-1);
                l++;
            }
            if(cnt==mp.size()&& len>i-l+1) {
                st = l;
                len = i-l+1;
            }
        }
        return st==-1?"":s.substring(st, st+len);
    }
}
