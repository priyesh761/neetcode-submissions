class Twitter {
    unordered_map<int, vector<int>> posts;
    unordered_map<int,int> timestamp;
    unordered_map<int, unordered_set<int>> follows;
    int cnt=0;
public:
    Twitter() {
        
    }
    
    void postTweet(int userId, int tweetId) {
        if(posts.count(userId)==false) posts[userId] = vector<int>();
        posts[userId].push_back(tweetId);
        timestamp[tweetId] = cnt;
        cnt++;
    }
    
    vector<int> getNewsFeed(int userId) {
        priority_queue<vector<int>> pq;
        unordered_set<int> feedUsers = follows.count(userId)
            ? follows[userId]
            : unordered_set<int>();
        feedUsers.insert(userId);
        for(int followed: feedUsers) {
            if(posts[followed].empty()) continue;
            int sz = posts[followed].size();
            int postId = posts[followed][sz-1];
            pq.push({timestamp[postId], sz-1, followed});
        }

        vector<int> res = vector<int>();
        while(res.size()<10&&!pq.empty()) {
            vector<int> postInfo = pq.top();
            pq.pop();
            res.push_back(posts[postInfo[2]][postInfo[1]]);
            if(postInfo[1]>0) {
                int postId = posts[postInfo[2]][postInfo[1]-1];
                pq.push({ timestamp[postId], postInfo[1]-1, postInfo[2]});
            }
        }
        return res;
    }
    
    void follow(int followerId, int followeeId) {
        if(follows.count(followerId)==false) follows[followerId] = unordered_set<int>();
        follows[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        follows[followerId].erase(followeeId);
    }
};
