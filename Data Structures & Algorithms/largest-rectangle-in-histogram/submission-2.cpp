class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> lsm(heights.size());
        stack<int> st;
        int mx=0;
        for(int i=0; i<heights.size(); i++) {
            while(!st.empty() && heights[st.top()]>=heights[i]) {
                mx = max(mx, heights[st.top()]*(i-1-lsm[st.top()])); 
                st.pop();
            }
            lsm[i] = st.empty() ? -1: st.top();
            st.push(i);
        }
        while(!st.empty()) {
            mx = max(mx, heights[st.top()]*((int)heights.size()-1-lsm[st.top()])); 
            st.pop();
        }
        
        return mx;
    }
};
