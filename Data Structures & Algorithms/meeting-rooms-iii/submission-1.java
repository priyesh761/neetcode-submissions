class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        int[] rooms = new int[n];
        Queue<Integer> qu = new PriorityQueue<>();
        Queue<int[]> resv = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i=0;i<n;i++) {
            qu.add(i);
        }
        int mx=0, st=0;
        for(int[] meet: meetings) {
            st = Math.max(meet[0], st);
            while(!resv.isEmpty()&&resv.peek()[0]<=st) {
                int[] unreserve = resv.remove();
                qu.add(unreserve[1]);
            }
            if(qu.isEmpty()) {
                st = Math.max(resv.peek()[0], st);
                while(!resv.isEmpty()&&resv.peek()[0]<=st) {
                    int[] unreserve = resv.remove();
                    qu.add(unreserve[1]);
                }
            }
            int reserve = qu.remove();
            // System.out.println(""+reserve+" "+meet[0]+" "+st);
            rooms[reserve]++;
            mx = Math.max(rooms[reserve], mx);
            resv.add(new int[]{meet[1]+st-meet[0], reserve});
        }
        int cnt=0;
        for(int i=0;i<rooms.length;i++) {
            if(mx==rooms[i]) return i;
        }
        return cnt;
    }
}