
class TrieNode {
    public Map<Character, TrieNode> mp;
    public boolean isEnd;

    TrieNode() {
        mp = new HashMap<>();
        isEnd = false;
    }
}
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode node = new TrieNode();
        for(String str: dictionary) {
            add(node, str);
        }
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            mark(node, res, s, i);
        }
        res.sort((a,b)-> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int[] len = new int[res.size()];
        for(int i=0;i<res.size();i++) {
            len[i] = res.get(i)[0];
            for(int j=0;j<i;j++) {
                if(res.get(j)[1]<res.get(i)[0]){
                    len[i] = Math.min(len[i], len[j]+res.get(i)[0]-res.get(j)[1]-1);
                }
            }
        }
        int mx=s.length();
        for(int i=0;i<len.length;i++) {
            System.out.println(""+res.get(i)[0]+" "+res.get(i)[1]+" "+len[i]);
            mx = Math.min(mx, len[i]+s.length()-res.get(i)[1]-1);
        }
        return mx;
    }

    private void mark(TrieNode node, List<int[]> res, String s, int i) {
        int st = i;
        while(i<s.length()) {
            if(node.mp.containsKey(s.charAt(i))){
                node = node.mp.get(s.charAt(i));
            } else {
                return;
            }
            if(node.isEnd) res.add(new int[]{st, i});
            i++;
        }
    }

    private void add(TrieNode node, String s) {
        for(char c: s.toCharArray()) {
            if(!node.mp.containsKey(c)) {
                node.mp.put(c, new TrieNode());
            }
            node = node.mp.get(c);
        }
        node.isEnd = true;
    }
 }