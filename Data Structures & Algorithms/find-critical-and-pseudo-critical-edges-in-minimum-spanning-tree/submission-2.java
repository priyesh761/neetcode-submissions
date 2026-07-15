class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }

    void merge(int x, int y) {
        int px = getParent(x);
        int py = getParent(y);
        if (px == py)
            return;
        parent[py] = px;
        return;
    }

    boolean isSingle() {
        for (int i : parent) {
            if (getParent(i) != getParent(0)) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    int calcMST(int n, List<List<Integer>> edgeList, int edgeInd, boolean force) {
        int wt = 0;
        DSU dsu = new DSU(n);
        if (force) {
            List<Integer> edg =
                edgeList.stream().filter(e -> e.get(3) == edgeInd).findFirst().get();
            dsu.merge(edg.get(0), edg.get(1));
            wt += edg.get(2);
        }
        for (List<Integer> edge : edgeList) {
            // System.out.println(""+t.get(0)+" "+t.get(1)+" "+t.get(2)+" "+t.get(3));
            if (edge.get(3) == edgeInd)
                continue;
            int px = dsu.getParent(edge.get(0));
            int py = dsu.getParent(edge.get(1));
            if (px == py)
                continue;

            dsu.merge(edge.get(0), edge.get(1));
            wt += edge.get(2);
        }
        return dsu.isSingle() ? wt : -1;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> edgeList =
            IntStream.range(0, edges.length)
                .mapToObj(i -> {
                    List<Integer> lst =
                        Arrays.stream(edges[i]).boxed().collect(Collectors.toList());
                    lst.add(i);
                    return lst;
                })
                .sorted((a, b) -> a.get(2) - b.get(2))
                .toList();

        List<Integer> critical, pcritical;
        critical = new ArrayList<>();
        pcritical = new ArrayList<>();

        int mn = calcMST(n, edgeList, -1, false);
        System.out.println(mn);
        for (int i = 0; i < edgeList.size(); i++) {
            int cost = calcMST(n, edgeList, i, false);
            System.out.println("Cost without " + cost);

            if (cost == -1 || cost > mn) {
                critical.add(i);
            } else {
                int costForce = calcMST(n, edgeList, i, true);
                System.out.println("Cost force " + costForce);
                if (costForce == mn)
                    pcritical.add(i);
            }
        }

        return List.of(critical.stream().toList(), pcritical.stream().toList());
    }
}