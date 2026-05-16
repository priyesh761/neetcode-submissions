class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int k, int v, ListNode p, ListNode n) {
        key = k;
        val = v;
        prev = p;
        next = n;
    }
}
class LFUList {
    ListNode head;
    ListNode tail;
    int size;

    LFUList() {
        head = new ListNode(-1, -1, null, null);
        tail = new ListNode(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
        size=0;
    }

    public ListNode first() {
        return head.next;
    }

    public ListNode last() {
        return tail.prev;
    }

    public void addNode(ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;      
    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--; 
    }
}
class LFUCache {
    int capacity;
    Map<Integer, Integer> mp;
    Map<Integer, Integer> freq;
    Map<Integer, LFUList> lfu;
    Map<Integer, ListNode> lnd;
    int min;
 

    public LFUCache(int capacity) {
        mp = new HashMap<>();
        freq = new HashMap<>();
        lfu = new HashMap<>();
        lnd = new HashMap<>();
        this.capacity = capacity;
        min=0;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)) {
            update(key);
        }
        return mp.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(!mp.containsKey(key)) {
            if(mp.size()==capacity) {
                invalidate();
            }
            min=1;
            freq.put(key, 1);

            ListNode nd = new ListNode(key, value, null, null);
            lnd.put(key, nd);
            lfu.computeIfAbsent(1, (k)->new LFUList()).addNode(nd);
            mp.put(key, value);
            return;
        }
        update(key);
        mp.put(key, value);
    }

    private void update(int key) {
        int fq = freq.compute(key, (k,v)->v+1);
        ListNode nd = lnd.get(key);
        lfu.get(fq-1).removeNode(nd);
        lfu.computeIfAbsent(fq, (k)->new LFUList()).addNode(nd);
        if(min==fq-1 && lfu.get(fq-1).size==0) min = fq;
    }
    private void invalidate() {
        ListNode rem = lfu.get(min).first();
        lfu.get(min).removeNode(rem);
        lnd.remove(rem.key);
        freq.remove(rem.key);
        mp.remove(rem.key);
        return;
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */