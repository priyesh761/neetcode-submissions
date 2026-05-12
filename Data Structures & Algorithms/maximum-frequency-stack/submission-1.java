class FreqStack {
    Map<Integer, Integer> mp;
    Stack<Stack<Integer>> st;
    int time;
    public FreqStack() {
        st = new Stack<>();
        mp = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = mp.compute(val, (k,  v) -> v==null?1:v+1);
        if(freq>st.size()) {
            st.push(new Stack<>());
        }
        st.get(freq-1).push(val);
    }
    
    public int pop() {
        int val = st.peek().pop();
        if(st.peek().isEmpty()) st.pop();

        int freq = mp.get(val);
        if(freq>1) mp.put(val, freq-1);
        else mp.remove(val);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */