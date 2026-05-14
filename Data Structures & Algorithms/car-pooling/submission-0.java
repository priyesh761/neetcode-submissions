class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b)-> {
            if(a[1]==b[1]) return a[2]-b[2];
            return a[1]-b[1];
        });
        Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int[] trip: trips) {
            while(!pq.isEmpty()&& pq.peek()[0]<=trip[1]) {
                capacity += pq.peek()[1];
                pq.remove();
            }
            if(trip[0]>capacity) return false;
            capacity -= trip[0];
            pq.add(new int[]{trip[2], trip[0]});
        }
        return true;
    }
}