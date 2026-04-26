class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> mp = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, Integer> outdegree = new HashMap<>();
        int cnt=0;
        for(List<String> ticket: tickets) {
            List<String> out = mp.computeIfAbsent(ticket.get(0), k->new ArrayList<String>());
            out.add(ticket.get(1));
            mp.putIfAbsent(ticket.get(1), new ArrayList<String>());
            outdegree.compute(ticket.get(0), (k,v)-> v==null?1:v+1);
            outdegree.putIfAbsent(ticket.get(1), 0);
            indegree.compute(ticket.get(1), (k,v)-> v==null?1:v+1);
            indegree.putIfAbsent(ticket.get(0), 0);
        }

        String start = "JFK", end = "";
        for(String loc: indegree.keySet()) {
            // System.out.println(loc+" "+indegree.get(loc)+" "+outdegree.get(loc));
            if (indegree.get(loc)-outdegree.get(loc)==1) {
                end = loc;
            }
        }
        Map<String, Queue<String>> nmp = mp.entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                    .stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayDeque::new))));
        List<String> res = new ArrayList<>();
        dfs(nmp, res, "JFK");
        return res.reversed();
    }

    private void dfs(Map<String, Queue<String>> mp, List<String> res, String curr) {
        
        Queue<String> qu = mp.get(curr);
        // System.out.println(""+ curr+ "-"+qu.size());
        while(qu.isEmpty()==false) {
            String next = qu.remove();
            dfs(mp, res, next);
        }
        res.add(curr);
        return;
    }
}
