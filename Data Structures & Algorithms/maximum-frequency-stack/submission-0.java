class FreqStack {
    Map<Integer, Integer> mp;
    PriorityQueue<int[]> pq;
    int time;
    public FreqStack() {
        pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });
        mp = new HashMap<>();
        time = 0;
    }
    
    public void push(int val) {
        time++;
        int freq = mp.compute(val, (k,  v) -> v==null?1:v+1);
        pq.add(new int[]{freq, time, val});
    }
    
    public int pop() {
        int[] ar = pq.remove();
        if(ar[0]>1) mp.put(ar[2], ar[0]-1);
        return ar[2];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */