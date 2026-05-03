class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op: operations) {
            if(op.equals("C")) st.pop();
            else if(op.equals("D")) st.push(st.peek()*2);
            else if(op.equals("+")) {
                int f = st.get(st.size()-1);
                int s = st.get(st.size()-2);
                st.push(f+s);
            } else st.push(Integer.parseInt(op));
        }
        return st.stream().reduce(0, Integer::sum);
    }
}