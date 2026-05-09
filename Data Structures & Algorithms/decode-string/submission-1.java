class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        String num = "";
        Stack<String> st = new Stack<>();
        Stack<Integer> stc = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c=='[') {
                stc.push(Integer.parseInt(num));
                st.push(result.toString());
                result.delete(0, result.length());
                num = "";
            } else if(c==']') {
                int n = stc.pop();
                String temp = result.toString();
                while(n>1){
                    result.append(temp);
                    n--;
                }
                result.insert(0, st.pop());
            } else if(Character.isDigit(c)){
                num += c;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}