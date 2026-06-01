class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder res = new StringBuilder();
        boolean isA = a>0, isB = b>0, isC = c>0;
        int sum = a+b+c;
        while(isA||isB||isC) {
            Map<Character, Integer> mp = new HashMap<>();
            if(isA) mp.put('a', a);
            if(isB) mp.put('b', b);
            if(isC) mp.put('c', c);
            char ch = getMax(mp);
            res.append(ch);
            System.out.println(res);
            if(ch=='a') a--;
            if(ch=='b') b--;
            if(ch=='c') c--;
            int len = res.length();
            if(len>=2) {
                if(res.charAt(len-1)=='a' && res.charAt(len-2)=='a') {
                    isA = false;
                }
                if(res.charAt(len-1)=='b' && res.charAt(len-2)=='b') {
                    isB = false;
                }
                if(res.charAt(len-1)=='c' && res.charAt(len-2)=='c') {
                    isC = false;
                }
                if(!isA && ch!='a') isA = true;
                if(!isB && ch!='b') isB = true;
                if(!isC && ch!='c') isC = true;
                if(a==0) isA = false;
                if(b==0) isB = false;
                if(c==0) isC = false;
            }
        }
        return res.toString();
    }
    private char getMax(Map<Character, Integer> mp) {
        return Collections.max(mp.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}