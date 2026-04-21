class MyCircularQueue {
    int start;
    int end;
    int size;
    int[] qu;
    public MyCircularQueue(int k) {
        qu = new int[k];
        start=1;
        end=0;
        size=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        end++;
        if(start==-1) start = end;
        qu[end%size] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        start++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return qu[start%size];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return qu[end%size];
    }
    
    public boolean isEmpty() {
        return (start>end || start==-1); 
    }
    
    public boolean isFull() {
        return end-start+1==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */