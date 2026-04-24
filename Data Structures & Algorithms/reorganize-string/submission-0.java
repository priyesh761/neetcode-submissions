class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()) {
            mp.compute(c, (k, v)-> v==null?1:v+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (Character a, Character b)-> mp.get(b)-mp.get(a));

        for(char c : mp.keySet()) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size()>1) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            int n1 = mp.compute(c1, (k,v)->v-1);
            int n2 = mp.compute(c2, (k,v)->v-1);
            if(n1>0) pq.add(c1);
            if(n2>0) pq.add(c2);
            sb.append(c1);
            sb.append(c2);
        }
        if(pq.size()>0) {
            char c = pq.poll();
            if(mp.get(c)>1) return "";
            sb.append(c);
        }
        return sb.toString();
    }
}