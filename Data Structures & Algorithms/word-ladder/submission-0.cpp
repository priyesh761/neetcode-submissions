class Solution {
    int hasEdge(string& s1, string& s2) {
        int cnt=0;
        for(int i=0; i<s1.length(); i++) {
            cnt += (s1[i]!=s2[i]);
        }
        return cnt==1;
    }
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        auto beginItr = find(wordList.begin(), wordList.end(), beginWord);
        auto endItr = find(wordList.begin(), wordList.end(), endWord);

        int src, en;
        if(beginItr==wordList.end()) {
            src = wordList.size();
            wordList.push_back(beginWord);
        } else src = beginItr - wordList.begin();

        if(endItr==wordList.end()) {
            en = wordList.size();
            wordList.push_back(endWord);
        } else en = endItr - wordList.begin();
        
        vector<bool> vis(wordList.size());
        queue<pair<int,int>> qu;
        qu.push({src, 1});
        vis[src] = true;
        while(!qu.empty()) {
            int wid, dist;
            tie(wid, dist) = qu.front();
            qu.pop();
            
            for(int i=0;i<wordList.size();i++) {
                if(vis[i]==false && hasEdge(wordList[wid], wordList[i])) {
                    qu.push({i, dist+1});
                    vis[i] = true;
                    if(i==en) return dist+1;
                }
            }
        }
        return 0;
    }
};
