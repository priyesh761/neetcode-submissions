class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = IntStream.range(0, numCourses)
                                        .mapToObj(i-> new ArrayList<Integer>())
                                        .collect(Collectors.toList());
        List<Set<Integer>> par = IntStream.range(0, numCourses)
                                        .mapToObj(i -> new HashSet<Integer>())
                                        .collect(Collectors.toList());
        for(int[] req: prerequisites) {
            indegree[req[1]]++;
            graph.get(req[0]).add(req[1]);
        }
        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) {
                qu.add(i);
            }
        }

        while(!qu.isEmpty()) {
            int node = qu.remove();
            for(int i: graph.get(node)) {
                indegree[i]--;
                par.get(i).add(node);
                par.get(i).addAll(par.get(node));
                if(indegree[i]==0) {
                    qu.add(i);
                }
            }
        }

        return Arrays.stream(queries)
        .map(q->par.get(q[1]).contains(q[0]))
        .collect(Collectors.toList());
    }
}