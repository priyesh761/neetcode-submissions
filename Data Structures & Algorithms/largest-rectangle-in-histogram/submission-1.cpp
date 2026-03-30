class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> lsm(heights.size());
        stack<int> st;
        for(int i=0; i<heights.size(); i++) {
            while(!st.empty() && heights[st.top()]>=heights[i]) st.pop();
            lsm[i] = st.empty() ? -1: st.top();
            st.push(i);
        }
        
        int mx=0;
        stack<int> st2;
        for(int i=heights.size()-1; i>=0; i--) {
            while(!st2.empty() && heights[st2.top()]>=heights[i]) st2.pop();
            int rt = st2.empty() ? heights.size(): st2.top();
            mx = max(mx, heights[i]*(rt-lsm[i]-1));
            st2.push(i);
        }
        return mx;
    }
};
