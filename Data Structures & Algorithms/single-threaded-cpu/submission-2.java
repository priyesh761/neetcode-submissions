class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] taskWithIndex = IntStream.range(0, tasks.length)
            .mapToObj(i -> new int[]{tasks[i][0], tasks[i][1], i})
            .sorted((a, b)->{
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            })
            .toArray(int[][]::new);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> taskWithIndex[a][1]-taskWithIndex[b][1]);
        List<Integer> res = new ArrayList<>();
        pq.add(0);
        int i=1;
        int bound = 0;
        while(res.size()<taskWithIndex.length) {
            int nxt = pq.remove();
            res.add(taskWithIndex[nxt][2]);
            bound = Math.max(bound, taskWithIndex[nxt][0])+taskWithIndex[nxt][1];
            while(i<taskWithIndex.length && taskWithIndex[i][0]<=bound) {
                pq.add(i);
                i++;
            }
            if(pq.isEmpty() && i<taskWithIndex.length) pq.add(i++);
        }
        return res.stream()
            .mapToInt(e->e)
            .toArray();
    }
}