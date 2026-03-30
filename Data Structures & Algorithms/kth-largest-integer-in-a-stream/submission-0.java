class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        pq.addAll(list);
        while(pq.size()>k) pq.remove();
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>size) pq.remove();
        return pq.peek();
    }
}
