class MyQueue {
    Stack<Integer> st, qu;
    public MyQueue() {
        st = new Stack<>();
        qu = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(qu.isEmpty()) {
            while(!st.isEmpty()) {
                qu.push(st.pop());
            }
        }
        return qu.pop();
    }
    
    public int peek() {
        if(qu.isEmpty()) {
            while(!st.isEmpty()) {
                qu.push(st.pop());
            }
        }
        return qu.peek();
    }
    
    public boolean empty() {
        return st.isEmpty() && qu.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */