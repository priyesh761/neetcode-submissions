class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        ArrayList<int[]> ar = new ArrayList();

        for(int[] interval: intervals) {
            if (ar.isEmpty() || ar.get(ar.size()-1)[1] < interval[0]) {
                ar.add(interval);
            } else {
                int[] last = ar.get(ar.size()-1);
                int[] newInterval = new int[]{last[0], Math.max(last[1], interval[1])};
                ar.set(ar.size()-1, newInterval);
            }
        }

        return ar.toArray(new int[0][]);
    }
}
