class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Integer>[] graph = new ArrayList[n];
        List<Integer>[] weight = new ArrayList[n];
        Arrays.setAll(graph, i->new ArrayList<Integer>());
        Arrays.setAll(weight, i->new ArrayList<Integer>());
        
        for(int[] edge: times) {
            graph[edge[0]-1].add(edge[1]-1);
            weight[edge[0]-1].add(edge[2]);
        }
        
        Queue<List<Integer>> pq = new PriorityQueue<List<Integer>>(
            (List<Integer> a, List<Integer> b) -> {
                return a.get(1)-b.get(1);
            }
        );
        Map<Integer, Integer> mp = new HashMap<>();
        pq.add(List.of(k-1, 0));
        mp.put(k-1, 0);

        while(!pq.isEmpty()) {
            List<Integer> curr = pq.remove();
            int currNode = curr.get(0);
            int currWeight = curr.get(1);
            List<Integer> nxt = graph[currNode];
            List<Integer> nxtWeight = weight[currNode];
            for(int i=0;i<nxt.size();i++) {
                int nxtNode = nxt.get(i);
                int currBest = mp.getOrDefault(nxtNode, Integer.MAX_VALUE);
                int candidate = currWeight + nxtWeight.get(i);
                if(candidate<currBest) {
                    mp.put(nxtNode, candidate);
                    pq.add(List.of(nxtNode, candidate));
                }
            }
        }
        return mp.size()==n ? Collections.max(mp.values()):-1;
    }
}
