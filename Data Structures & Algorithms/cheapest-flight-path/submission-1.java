class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> weight = new ArrayList<>();
        PriorityQueue<int[]> qu = new PriorityQueue<>((int[] a, int[] b)->a[1]-b[1]);

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<Integer>());
            weight.add(new ArrayList<Integer>());
        }
        for(int[] fl: flights) {
            graph.get(fl[0]).add(fl[1]);
            weight.get(fl[0]).add(fl[2]);
        }

        qu.add(new int[]{src, 0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!qu.isEmpty()) {
            int[] node = qu.remove();
            int curr = node[0];
            int cost = node[1];
            int nm = node[2];
            //System.out.println(""+ curr+" "+cost+" "+nm);
            if(curr==dst) {
                return cost;
            }
            if(nm>k) continue;
            for(int i=0;i<graph.get(curr).size();i++){
                int next = graph.get(curr).get(i);
                int nxWt = weight.get(curr).get(i);
                dist[next] = cost+nxWt;
                qu.add(new int[]{next, cost+nxWt, nm+1});
            }
        }
        return -1;
    }
}
