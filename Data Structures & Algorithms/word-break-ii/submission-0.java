
class Solution {
    public void generate(String s,
        List<List<Integer>> mapping,
        Deque<String> temp,
        List<String> ans,
        int ind) {
            if(ind==-1) {
                List<String> ar = new ArrayList<>(temp);
                Collections.reverse(ar);
                ans.add(String.join(" ", ar));
                return;
            }

            for(int i: mapping.get(ind)) {
                temp.add(s.substring(i+1, ind+1));
                generate(s, mapping, temp, ans, i);
                temp.removeLast();
            }
            return;
        }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<List<Integer>> mapping = IntStream.range(0,s.length())
            .mapToObj(k->new ArrayList<Integer>())
            .collect(Collectors.toList());
        for(int i=0;i<s.length();i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<s.length();j++) {
                sb.append(s.charAt(j));
                if(dict.contains(sb.toString())) {
                    mapping.get(j).add(i-1);
                }
            }
        }   
        List<String> res = new ArrayList<>(); 
        generate(s,
            mapping,
            new ArrayDeque<String>(),
            res,
            s.length()-1);
        return res;    
    }
}