class Solution {
    public int candy(int[] ratings) {
        int[] indegree = new int[ratings.length];
        Queue<int[]> qu = new ArrayDeque<>();

        int[][] edge = new int[ratings.length][2];
        for(int[] rw: edge) {
            Arrays.fill(rw, -1);
        }

        for(int i=0;i<ratings.length;i++) {
            if(i>0&&ratings[i]<ratings[i-1]) {
                edge[i][0] = 1;
                indegree[i-1]++;
            }
            if(i<ratings.length-1&&ratings[i]<ratings[i+1]) {
                edge[i][1] = 1;
                indegree[i+1]++;
            }
        }
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) qu.add(new int[]{i, 1});
            System.out.println(""+indegree[i]+"-"+edge[i][0]+"-"+edge[i][1]);
        }
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        while(!qu.isEmpty()) {
            int[] curr = qu.remove();
            System.out.println(""+curr[0]+":"+curr[1]);
            ans[curr[0]] = Math.max(ans[curr[0]], curr[1]);
            if(edge[curr[0]][0]==1) {
                indegree[curr[0]-1]--;
                if(indegree[curr[0]-1]==0) {
                    int nxt = curr[1] + (ratings[curr[0]]==ratings[curr[0]-1]?0:1);
                    qu.add(new int[]{curr[0]-1, nxt});
                }
            }
            if(edge[curr[0]][1]==1) {
                indegree[curr[0]+1]--;
                if(indegree[curr[0]+1]==0) {
                    int nxt = curr[1] + (ratings[curr[0]]==ratings[curr[0]+1]?0:1);
                    qu.add(new int[]{curr[0]+1, nxt});
                }
            }
        }
        int res=0;
        for(int i: ans) {
            System.out.print(""+i+" ");
            res+=i;
        }
        return res;
    }
}