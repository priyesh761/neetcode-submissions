class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder res = new StringBuilder();
        char[] chr = {'a', 'b', 'c'};
        int[] count = {a, b, c};
        boolean[] valid = {a>0, b>0, c>0};
        boolean isValid = valid[0]||valid[1]||valid[2];
        int sum = a+b+c;
        while(isValid) {
            Map<Character, Integer> mp = new HashMap<>();
            for(int i=0;i<3;i++) {
                if(valid[i]) mp.put(chr[i], count[i]);
            }
            char ch = getMax(mp);
            res.append(ch);
            System.out.println(res);
            for(int i=0;i<3;i++) {
                if(ch == chr[i]) count[i]--;
                if(count[i]==0) valid[i] = false;
            }
            int len = res.length();
            for(int i=0;i<3;i++) {
                if(len>=2 && res.charAt(len-1)==chr[i] && res.charAt(len-2)==chr[i]) {
                    valid[i] = false;
                }
                if(!valid[i] && ch!=chr[i] && count[i]>0) valid[i] = true;
            }
            isValid = valid[0]||valid[1]||valid[2];
        }
        return res.toString();
    }
    private char getMax(Map<Character, Integer> mp) {
        return Collections.max(mp.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}