class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> dq = new ArrayDeque<>();
        int i=0;
        while(i<path.length()) {
            while(i<path.length()&&path.charAt(i)=='/') i++;
            StringBuilder sb = new StringBuilder();
            while(i<path.length()&&path.charAt(i)!='/') {
                sb.append(path.charAt(i));
                i++;
            }

            if(sb.toString().equals(".")) continue;
            else if(sb.toString().equals("..")) {
                if(!dq.isEmpty()) dq.removeLast();
            }
            else if(!sb.isEmpty()) dq.add(sb.toString());
        }

        return "/"+String.join("/", dq);
    }
}