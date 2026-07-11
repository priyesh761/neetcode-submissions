class Solution {
    int[][] dir =
        new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    boolean check(Set<Map.Entry<Integer, Integer>> st, int x, int y, int n, int dx, int dy) {
        int i = dx, j = dy;
        while (x+i > 0 && y+j > 0 && x + i <= n && y + j <= n) {
            if (st.contains(Map.entry(x + i, y + j)))
                return false;
            i += dx;
            j += dy;
        }
        return true;
    }

    public int calc(Set<Map.Entry<Integer, Integer>> st, int row, int n) {
        if (row == 0) {
            return 1;
        }
        int res = 0;
        for (int col = 1; col <= n; col++) {
            boolean safe = true;
            for (int[] dr : dir) {
                safe = safe && check(st, row, col, n, dr[0], dr[1]);
            }
            if (safe) {
                Map.Entry<Integer, Integer> entry = Map.entry(row, col);
                st.add(entry);
                res += calc(st, row - 1, n);
                st.remove(entry);
            }
        }
        return res;
    }

    public int totalNQueens(int n) {
        Set<Map.Entry<Integer, Integer>> st = new HashSet<>();
        return calc(st, n, n);
    }
}