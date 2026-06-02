
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];
        int[] indegree = new int[k];
        Map<Integer, List<Integer>> mp1 = new HashMap<>();
        for(int[] condition: rowConditions) {
            condition[0]--;
            condition[1]--;
            indegree[condition[1]]++;
            mp1.putIfAbsent(condition[0], new ArrayList());
            mp1.get(condition[0]).add(condition[1]);
        }

        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=0;i<k;i++) {
            mp1.putIfAbsent(i, new ArrayList<>());
            if(indegree[i]==0) qu.add(i);
        }

        int r=0;
        Map<Integer, Integer> row = new HashMap<>();
        while(!qu.isEmpty()) {
            int x = qu.remove();
            row.put(x, r);
            r++;
            for(int i: mp1.get(x)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    qu.add(i);
                }
            }
        }
        if(r!=k) return new int[0][0];

        Map<Integer, List<Integer>> mp2 = new HashMap<>();
        for(int[] condition: colConditions) {
            condition[0]--;
            condition[1]--;
            indegree[condition[1]]++;
            mp2.putIfAbsent(condition[0], new ArrayList());
            mp2.get(condition[0]).add(condition[1]);
        }
        for(int i=0;i<k;i++) {
            mp2.putIfAbsent(i, new ArrayList<>());
            if(indegree[i]==0) qu.add(i);
        }
        int c=0;
        while(!qu.isEmpty()) {
            int x = qu.remove();
            int rw = row.get(x);
            res[rw][c] = x+1;
            c++;
            for(int i: mp2.get(x)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    qu.add(i);
                }
            }
        }
        return r==k&&c==k ? res : new int[0][0];
    }
}