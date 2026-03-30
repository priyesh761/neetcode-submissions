class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> mp = new HashMap();
        for(int i=0;i<s.length();i++) {
            mp.putIfAbsent(s.charAt(i), new ArrayList<Integer>(List.of(i,-1)));
            List<Integer> bounds = mp.get(s.charAt(i));
            bounds.set(1, Math.max(bounds.get(1), i));
        }

        List<List<Integer>> ar = new ArrayList<>();
        for(int i=0; i<26; i++) {
            char c1 = (char)('a'+i);
            if(!mp.containsKey(c1)) continue;
            ar.add(mp.get(c1));
        }

        ar.sort((List<Integer> a, List<Integer> b)->{
            if(a.get(0)==b.get(0)) {
                return a.get(1)-b.get(1);
            }
            return a.get(0)-b.get(0);
        });
        
        int i=0;
        List<List<Integer>> result = new ArrayList<>();
        while(i<ar.size()) {
            int mn = ar.get(i).get(0);
            int mx = ar.get(i).get(1);
            while(i<ar.size() && mx>=ar.get(i).get(0)) {
                mx = Math.max(mx, ar.get(i).get(1));
                i++;
            }
            result.add(List.of(mn, mx));
        }
        return result.stream()
            .map((List<Integer> l)->l.get(1)-l.get(0)+1)
            .toList();
    }
}
