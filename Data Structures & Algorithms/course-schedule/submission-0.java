class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ind = new int[numCourses];
        
        for(int[] req: prerequisites) {
            graph.get(req[1]).add(req[0]);
            ind[req[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        for(int i=0;i<ind.length;i++) {
            if(ind[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            cnt++;
            for(int dep: graph.get(course)) {
                ind[dep]--;
                if(ind[dep]==0) {
                    q.add(dep);
                }
            }
        }

        return cnt==numCourses;
    }
}
