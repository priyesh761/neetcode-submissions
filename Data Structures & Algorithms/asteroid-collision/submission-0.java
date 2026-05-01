class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i: asteroids) {
            if(i>0){
                st.push(i);
                continue;
            }
            while(!st.isEmpty()&& st.peek()>0 && st.peek()<-1*i) {
                st.pop();
            }
            if(st.isEmpty()||st.peek()<0) st.push(i);
            else if(st.peek()==-1*i) st.pop();
        }
        return st.stream().mapToInt(v->v).toArray();
    }
}