class DSU {
    Map<Integer, Integer> parent;

    DSU() {
        parent = new HashMap<Integer, Integer>();
    }

    public Integer getParent(Integer node) {
        Integer par = parent.get(node);
        if(par.equals(node)) {
            return node;
        }
        Integer root = getParent(par);
        parent.put(node, root);
        return root;
    }

    public void merge(Integer n1, Integer n2) {
        Integer p1 = getParent(n1);
        Integer p2 = getParent(n2);
        if(p1.equals(p2)) return;
        parent.put(p2,p1);
    }

    public void add(Integer node) {
        parent.put(node, node);
    }

    public List<List<Integer>> getMergedAccounts() {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        
        parent.entrySet()
            .stream()
            .forEach((e)-> {
                if(e.getKey()!=getParent(e.getKey())) {
                    if(!mp.containsKey(e.getValue())) {
                        mp.put(e.getValue(), new ArrayList<Integer>());
                    }
                    mp.get(e.getValue()).add(e.getKey());
                }
            });
        return mp.entrySet().stream()
            .map(e -> {
                List<Integer> list = new ArrayList<>();
                list.add(e.getKey());
                for(int m: e.getValue()) {
                    if(m%100!=0) list.add(m);
                }
                return list;
            })
            .toList();
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, String> mp =  new HashMap<>();
        Map<String, Integer> rmp = new HashMap<>();
        List<Integer> accountIds = IntStream.range(0, accounts.size())
            .map(i-> -1)
            .boxed()
            .collect(Collectors.toList());
        DSU dsu = new DSU();
        for(int i=0;i<accounts.size();i++) {
            List<String> acList = accounts.get(i);
            mp.put(i*100, acList.get(0));
            dsu.add(i*100);

            for(int j=1;j<acList.size();j++) {
                String currAccount = acList.get(j);
                int id = -1;
                if(!rmp.containsKey(currAccount)) {
                    id = i*100+j;
                    mp.put(id, currAccount);
                    rmp.put(currAccount, id);            
                    dsu.add(id);
                } else {
                    id = rmp.get(currAccount);
                }
                dsu.merge(i*100, id);
            }
        }
        return dsu.getMergedAccounts().stream()
            .map(e-> e.stream().map(v->mp.get(v)).toList())
            .toList();
    }
}