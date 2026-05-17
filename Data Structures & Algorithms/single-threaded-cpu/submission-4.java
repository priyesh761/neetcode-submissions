class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] index = IntStream.range(0, tasks.length)
            .boxed()
            .sorted((a, b)-> {
                if(tasks[a][0]==tasks[b][0]) {
                    return tasks[a][1]-tasks[b][1];
                }
                return tasks[a][0]-tasks[b][0];
            })
            .mapToInt(a->a)
            .toArray();

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> tasks[a][1]-tasks[b][1]);
        List<Integer> res = new ArrayList<>();
        pq.add(index[0]);
        int i=1;
        int bound = 0;
        while(res.size()<index.length) {
            int nxt = pq.remove();
            res.add(nxt);
            bound = Math.max(bound, tasks[nxt][0])+tasks[nxt][1];
            while(i<tasks.length && tasks[index[i]][0]<=bound) {
                pq.add(index[i]);
                i++;
            }
            if(pq.isEmpty() && i<tasks.length) pq.add(index[i++]);
        }
        return res.stream()
            .mapToInt(e->e)
            .toArray();
    }
}