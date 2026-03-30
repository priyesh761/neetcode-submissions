class MedianFinder {
    priority_queue<int, vector<int>, greater<int>> pqAsc;
    priority_queue<int> pqDsc;
    int size = 0;
    
    void equalize(
        priority_queue<int>& large,
        priority_queue<int, vector<int>, greater<int>>& small) {
        while (large.size() > small.size()) {
            int nm = large.top();
            large.pop();
            small.push(nm);
        }
    }
    void equalize(
        priority_queue<int, vector<int>, greater<int>>& large,
        priority_queue<int>& small) {
        while (large.size() > small.size()) {
            int nm = large.top();
            large.pop();
            small.push(nm);
        }
    }
public:
    MedianFinder() {}
    
    void addNum(int num) {
        if(size==0) pqDsc.push(num);
        else if (num>=pqDsc.top()) pqAsc.push(num);
        else pqDsc.push(num); 
        
        if(pqDsc.size()>pqAsc.size()) {
            equalize(pqDsc, pqAsc);
            //cout<<"Eql1-"<<pqAsc.size()<<" "<<pqDsc.size()<<""<<pqDsc.size()<<endl;
        }
        if(pqAsc.size()>pqDsc.size()) {
            equalize(pqAsc, pqDsc);
            //cout<<"Eql2-"<<pqAsc.size()<<" "<<pqDsc.size()<<endl;
        }
        if(!pqAsc.empty()) cout<<"Asc -"<<pqAsc.top()<<endl;
        if(!pqDsc.empty()) cout<<"Dsc -"<<pqDsc.top()<<endl;
        
        size++;
    }
    
    double findMedian() {
        return size%2 ?
            pqDsc.top() :
            ((pqAsc.top()+pqDsc.top())*1.0/2);
    }
};
