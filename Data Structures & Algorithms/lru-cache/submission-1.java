
class ListNode {
    public int key;
    public int val;
    public ListNode prev;
    public ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.val = value;
    }

    ListNode(int key, int value, ListNode next, ListNode prev) {
        this(key, value);
        this.next = next;
        this.prev = prev;
    }
}

class LRUList {
    public ListNode head;
    public ListNode tail;

    LRUList() {
        head = new ListNode(-1, -1, null, null);
        tail = head;
    }

    void view() {
        ListNode h = head.next;
        while(h!=null) {
            System.out.print(""+h.key+"-"+h.val+":");
            h = h.next;
        }
        System.out.println("Tail:"+tail.key+"--------");
    }
    void addFirst(ListNode node) {
        if(node==tail) tail = tail.prev;
        if(node.prev!=null) {
            node.prev.next = node.next;
        }
        if(node.next!=null) {
            node.next.prev = node.prev;
        }
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        if(next!=null) {
            next.prev = node;
            node.next = next;
        }
        if(tail==head) tail = node;
    }

    ListNode remove() {
        if(tail==head) return null;
        ListNode removed = tail;
        tail = removed.prev;
        tail.next = null;
        return removed;
    }
}
class LRUCache {
    private final int capacity;
    private final LRUList list;
    private final Map<Integer, ListNode> mp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LRUList();
        mp = new HashMap();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        ListNode node = mp.get(key);
        list.addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        System.out.println("PUT");
        list.view();
        ListNode node = mp.compute(key, (k, v)-> {
            if(v==null) return new ListNode(key, value);
            v.val = value;
            return v;
        });
        list.addFirst(node);
        list.view();
        while(mp.size()>capacity) {
            ListNode removed = list.remove();
            System.out.println("removed: "+removed.key+"+"+removed.val);
            mp.remove(removed.key);
        }
        list.view();
    }
}
