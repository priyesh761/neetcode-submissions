class Solution {
    public String predictPartyVictory(String senate) {
        int cntr=0, cntd=0;
        for(char c: senate.toCharArray()) {
            if(c=='R') cntr++;
            if(c=='D') cntd++;
        }
        Queue<Character> dq = senate.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.toCollection(ArrayDeque::new));
        int skr=0, skd=0;
        while(cntr!=0&&cntd!=0) {
            char c = dq.remove();
            if(c=='R') {
                if(skr>0) {
                    cntr--;
                    skr--;
                } else {
                    skd++;
                    dq.add(c);                    
                }
            } else {
                if(skd>0) {
                    cntd--;
                    skd--;
                } else {
                    skr++;
                    dq.add(c);                    
                }
            }
        }
        return cntr==0?"Dire":"Radiant";
    }
}