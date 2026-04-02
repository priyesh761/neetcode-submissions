class Edge {
    public int[] p1;
    public int[] p2;
    public int i1;
    public int i2;
    private final int id;
    static int cnt = 0;
    public Edge(int[] p1, int[] p2, int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
        this.p1 = p1;
        this.p2 = p2;
        cnt++;
        id = cnt;
    }
    public int getId() {
        return id;
    }
    public int dist() {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }

    public String toString() {
        return ""+p1[0]+" "+p1[1]
            +":"+p2[0]+" "+p2[1]
            +":"+dist();
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length==1) return 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(
            (Edge a, Edge b) -> a.dist() - b.dist()
        );
        pq.add(new Edge(points[0], points[0], 0, 0));
        Set<Integer> st = new HashSet<>();
        int cnt=0;
        while(pq.isEmpty()==false) {
            Edge e = pq.remove();
            //System.out.println(e);
            if(st.contains(e.i1)==false) {
                cnt += e.dist();
                st.add(e.i1);
                for(int i=0;i<points.length;i++) {
                    if(i==e.i1) continue;
                    pq.add(new Edge(points[e.i1], points[i], e.i1, i));
                }
            }
            if(st.contains(e.i2)==false) {
                cnt += e.dist();
                st.add(e.i2);
                for(int i=0;i<points.length;i++) {
                    if(i==e.i2) continue;
                    pq.add(new Edge(points[e.i2], points[i], e.i2, i));
                }
            }
        }
        return cnt;
    }
}
