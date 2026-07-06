class Edge {
    String from;
    String to;
    double weight;

    Edge(String f, String t, double w) {
        from = f;
        to = t;
        weight = w;
    }
}

double dfs(Map<String, List<Edge>> graph, String src, String dest, double pathWeight) {
    if(!graph.containsKey(src)||!graph.containsKey(dest)) return -1.0;
    if(src.equals(dest)) return pathWeight;

    for(Edge eg: graph.get(src)) {
        if(eg.to==null) continue;
        String to = eg.to;
        eg.to = null;
        double res = dfs(graph, to, dest, pathWeight*eg.weight);
        eg.to = to;
        if(res == -1.0) continue;
        return res;
    }
    return -1.0;
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> mp = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            List<String> edge = equations.get(i);
            if(mp.containsKey(edge.get(0))==false) {
                mp.put(edge.get(0), new ArrayList<Edge>());
            }
            if(mp.containsKey(edge.get(1))==false) {
                mp.put(edge.get(1), new ArrayList<Edge>());
            }
            mp.get(edge.get(0)).add(new Edge(edge.get(0), edge.get(1), values[i]));
            mp.get(edge.get(1)).add(new Edge(edge.get(1), edge.get(0), 1.0/values[i]));
        }

        double[] res = new double[queries.size()];
        int cnt=0;
        for(List<String> query: queries) {
            String src = query.get(0);
            String dest = query.get(1);
            res[cnt] = dfs(mp, src, dest, 1.0);
            cnt++;
        }
        return res;
    }
}