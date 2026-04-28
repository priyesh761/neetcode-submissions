class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<profits.length;i++) {
            list.add(List.of(profits[i], capital[i]));
        }
        list.sort((a,b)-> {
            if(a.get(1)==b.get(1)) return b.get(0)-a.get(0);
            return a.get(1)-b.get(1);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a );
        int i=0;
        do {
            while(i<list.size() && list.get(i).get(1)<=w) {
                pq.add(list.get(i).get(0));
                i++;
            }
            if(pq.isEmpty()) break;
            int mxPft = pq.remove();
            w += mxPft;
            k--;
        } while(k>0);

        return w;
    }
}