class PrefixTree {
    unordered_map<char, PrefixTree*> mp;
    bool isEnd = false;
public:
    PrefixTree() {
        
    }
    
    void insert(string word) {
        PrefixTree* curr = this; 
        for(char c: word) {
            if(curr->mp.count(c)==false) {
                curr->mp[c] = new PrefixTree();
            }
            curr = curr->mp[c];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) {
        PrefixTree* curr = this; 
        for(char c: word) {
            if(curr->mp.count(c)) {
                curr = curr->mp[c];
            } else {
                return false;
            }
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        PrefixTree* curr = this; 
        for(char c: prefix) {
            if(curr->mp.count(c)) {
                curr = curr->mp[c];
            } else {
                return false;
            }
        }
        return true;
    }
};
