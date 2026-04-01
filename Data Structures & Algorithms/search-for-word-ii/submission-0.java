class Trie {
    public Map<Character, Trie> childrens;
    public boolean isEnd;
    public static int[][] dir = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    Trie() {
        childrens = new HashMap<>();
        isEnd = false;
    }

    public void insert(String s) {
        Trie curr = this;
        for(char c: s.toCharArray()) {
            curr = curr.childrens
                .computeIfAbsent(c, k-> new Trie());
        }
        curr.isEnd = true;
    }

    private void fill(char[][] board, boolean[][] vis,
        Trie t, String s, Set<String> res, int r, int c) {
        if(vis[r][c]) return;
        vis[r][c] = true;
        Trie curr = t.childrens.get(board[r][c]);
        if(curr!=null) {
            String nstr = s+board[r][c];
            if(curr.isEnd) res.add(nstr);
            for(int[] dx: dir) {
                int x = r+dx[0];
                int y = c+dx[1];
                if(x<0||x>=board.length||y<0||y>=board[0].length) continue;
                fill(board, vis, curr, nstr, res, r+dx[0], c+dx[1]);
            }
        }
        vis[r][c] = false;
    }

    public Set<String> match(char[][] board, int r, int c) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        Set<String> res = new HashSet<>();
        fill(board, vis, this,"", res, r, c);
        return res;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        Trie trie = new Trie();

        for(String word: words) {
            trie.insert(word);
        }

        Set<String> st = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                st.addAll(trie.match(board, i, j));
            }
        }
        return new ArrayList<String>(st);
    }
}
