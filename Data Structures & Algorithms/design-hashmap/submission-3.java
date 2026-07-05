class MyHashMap {
    List<List<Map.Entry<Integer, Integer>>> list;
    final int size = 10000;
    public MyHashMap() {
        list = IntStream.range(0,size)
            .<List<Map.Entry<Integer, Integer>>>mapToObj(ArrayList<Map.Entry<Integer, Integer>>::new)
            .toList();
    }
    
    public void put(int key, int value) {
        remove(key);
        list.get(key%size).add(Map.entry(key, value));
    }
    
    public int get(int key) {
        List<Map.Entry<Integer, Integer>> val = list.get(key%size);
        for(Map.Entry<Integer, Integer> e: val) {
            if(e.getKey()==key) {
                return e.getValue();
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        List<Map.Entry<Integer, Integer>> val = list.get(key%size);
        for(int i=0;i<val.size();i++) {
            if(val.get(i).getKey()==key) {
                val.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */