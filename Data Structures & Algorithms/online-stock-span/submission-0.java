class StockSpanner {
    List<Integer> span;
    public StockSpanner() {
        span = new ArrayList<>();
    }
    
    public int next(int price) {
        span.add(price);
        int cnt=0;
        for(int i=span.size()-1;i>=0;i--) {
            if(span.get(i)>price) return span.size()-i-1;
        }
        return span.size();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */