class Solution {
    public int dfs(List<List<Integer>> graph, List<int[]> height, int curr, int par) {
        int[] ht = height.get(curr);

        for (int node : graph.get(curr)) {
            if (node != par) {
                int depth = dfs(graph, height, node, curr) + 1;
                if (ht[0] <= depth) {
                    ht[2] = ht[0];
                    ht[3] = ht[1];
                    ht[0] = depth;
                    ht[1] = node;
                } else if (ht[2] <= depth) {
                    ht[2] = depth;
                    ht[3] = node;
                }
            }
        }
        if (ht[0] == -1) {
            ht[0] = 0;
        }
        if (ht[2] == -1) {
            ht[2] = 0;
        }
        return ht[0];
    }

    public void dfs2(List<List<Integer>> graph, List<int[]> height, int curr, int par) {
        int[] currHt = height.get(curr);
        if (par != -1) {
            int[] parHt = height.get(par);
            for (int i : List.of(0, 2)) {
                if (parHt[i + 1] != curr) {
                    if (currHt[0] <= parHt[i] + 1) {
                        currHt[2] = currHt[0];
                        currHt[3] = currHt[1];
                        currHt[0] = parHt[i] + 1;
                        currHt[1] = par;
                    } else if (currHt[2] <= parHt[i] + 1) {
                        currHt[2] = parHt[i] + 1;
                        currHt[3] = par;
                    }
                }
            }
        }

        for (int node : graph.get(curr)) {
            if (node != par) {
                dfs2(graph, height, node, curr);
            }
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = IntStream.range(0, n).<List<Integer>>mapToObj(e -> new ArrayList<Integer>())
                .toList();
        List<int[]> height = IntStream.range(0, n).<int[]>mapToObj(e -> new int[] { -1, -1, -1, -1 }).toList();

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(graph, height, 0, -1);
        dfs2(graph, height, 0, -1);
        int mx = Integer.MAX_VALUE;
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i)[0] < mx)
                mx = height.get(i)[0];
            // System.out.println("" + i + " " + height.get(i)[0]
            //         + " " + height.get(i)[1] + " " + height.get(i)[2] + " " + height.get(i)[3]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i)[0] == mx)
                res.add(i);
        }
        return res;
    }
}