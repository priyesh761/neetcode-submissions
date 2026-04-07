class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int len = Arrays.stream(strs)
            .mapToInt(String::length)
            .min()
            .orElse(0);
        
        int mn=0;
        for(int i=0;i<len;i++) {
            for(String s: strs) {
                if(s.charAt(i)!=strs[0].charAt(i)) return s.substring(0, i);
            }
            mn++;
        }
        return strs[0].substring(0, mn);
    }
}