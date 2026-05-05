class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] ord = order.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<ord.length;i++) {
            mp.put(ord[i], i);
        }
        for(int i=1;i<words.length;i++) {
            if(compare(words[i-1], words[i], mp)) continue;
            return false;
        }
        return true;
    }

    boolean compare(String a, String b, Map<Character, Integer> mp) {
        int len = Math.min(a.length(), b.length());
        for(int i=0;i<len;i++) {
            int aseq = mp.get(a.charAt(i));
            int bseq = mp.get(b.charAt(i));
            if(aseq==bseq) continue;
            return aseq<bseq;
        }
        return a.length()<=b.length();
    }
}