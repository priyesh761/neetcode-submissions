class MyHashSet {
    List<List<Integer>> set;
    public MyHashSet() {
        set = IntStream.range(0, 100000)
            .mapToObj(k->new ArrayList<Integer>())
            .collect(Collectors.toList());
    }
    
    public void add(int key) {
        List<Integer> ar = set.get(key%set.size());
        if(ar.contains(key)) return;       
        set.get(key%set.size()).add(key);
    }
    
    public void remove(int key) {
        List<Integer> ar = set.get(key%set.size());
        int index = ar.indexOf(key);
        if(index==-1) return;
        ar.remove(index);
    }
    
    public boolean contains(int key) {
        return set.get(key%set.size()).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */