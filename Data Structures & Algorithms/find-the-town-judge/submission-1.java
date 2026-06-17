class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] p: trust) {
            indegree[p[1]-1]++;
            outdegree[p[0]-1]++;
        }

        int j=-1;
        for(int i=0;i<n;i++) {
            if(indegree[i]==n-1 && outdegree[i]==0) {
                if(j!=-1) return -1;
                j=i+1;
            }
        }
        return j;
    }
}