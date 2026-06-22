class Solution {
    int[][] dir = new int[][] {
        {1,0,0,0},
        {0,1,0,0},
        {0,0,1,0},
        {0,0,0,1},
        {-1,0,0,0},
        {0,-1,0,0},
        {0,0,-1,0},
        {0,0,0,-1}
    };
    public int[] getNum(String s) {
        return new int[] {
            s.charAt(0)-'0',
            s.charAt(1)-'0',
            s.charAt(2)-'0',
            s.charAt(3)-'0'
        };
    }
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        if(Arrays.stream(deadends).anyMatch("0000"::equals)) return -1;
        int[] start = new int[] {0,0,0,0};
        int[] end = getNum(target);

        Deque<Map.Entry<int[], Integer>> qu = new ArrayDeque();
        qu.add(Map.entry(start, 0));
        Set<String> st = new HashSet<>();
        while(!qu.isEmpty()) {
            Map.Entry<int[], Integer> entry = qu.removeFirst();
            int[] combination = entry.getKey();
            int turns = entry.getValue();
            for(int i=0;i<dir.length;i++) {
                int[] res = new int[]{
                    combination[0]+dir[i][0],
                    combination[1]+dir[i][1],
                    combination[2]+dir[i][2],
                    combination[3]+dir[i][3],
                };
                for(int j=0;j<res.length;j++) {
                    if(res[j]==-1) res[j]=9;
                    if(res[j]==10) res[j]=0;
                }
                String rstr = "" + String.valueOf(res[0])
                    + String.valueOf(res[1])
                    + String.valueOf(res[2])
                    + String.valueOf(res[3]);
                if(st.contains(rstr)) continue;
                boolean isEq = true;
                for(String deadcode: deadends) {
                    int[] dead = getNum(deadcode);
                    isEq = res[0]==dead[0] &&
                        res[1]==dead[1] &&
                        res[2]==dead[2] &&
                        res[3]==dead[3];
                    if(isEq) break;
                    
                }
                if(isEq) continue;
                if(rstr.equals(target)) return turns+1;
                st.add(rstr);
                qu.add(Map.entry(res,turns+1));
            }

        }
        return -1;
    }
}