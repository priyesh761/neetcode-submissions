class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};

        ArrayList<int[]> ar = new ArrayList<int[]>();
        for(int[] interval: intervals) {
            if(interval[1]<newInterval[0] || interval[0]>newInterval[1]) {
                if(interval[0]>newInterval[1] &&
                    (ar.isEmpty()||ar.get(ar.size()-1)[1]<newInterval[0])) {
                        ar.add(newInterval);
                    }
                ar.add(interval);
            } else {
                int mn =  Math.min(interval[0], newInterval[0]);
                int mx = Math.max(interval[1], newInterval[1]);
                if(ar.isEmpty() || ar.get(ar.size()-1)[1]<mn) {
                    ar.add(new int[] {mn, mx});
                } else {
                    mn = Math.min(mn, ar.get(ar.size()-1)[0]);
                    mx = Math.max(mx, ar.get(ar.size()-1)[1]);
                    ar.set(ar.size()-1, new int[]{mn, mx});
                }
            }
        }

        if(ar.get(ar.size()-1)[1]<newInterval[0]) {
            ar.add(newInterval);
        }

        return ar.toArray(new int[0][]);
    }
}
