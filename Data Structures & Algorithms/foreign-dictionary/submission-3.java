class Solution {
    private void addMapEntry(Map<Character, Set<Character>> graph, char key, Character val) {
        Set<Character> charSet = graph.get(key);
        if(charSet==null) {
            charSet = new HashSet<>();
            graph.put(key, charSet);
        }
        if (val!=null) charSet.add(val);
    }

    private boolean addMapping(Map<Character, Set<Character>> graph,
        String a, String b, int ind) {
        if(a.length()<=ind || b.length()<=ind) return a.length()<=b.length();
        
        if (a.charAt(ind) == b.charAt(ind)) { 
            return addMapping(graph, a, b, ind+1);
        } else {
            addMapEntry(graph, a.charAt(ind), b.charAt(ind));
            return true;
        }
    }

    private boolean initGraph(Map<Character, Set<Character>> graph, String[] words) {
        for(String word: words) {
            for(char c: word.toCharArray()) {
                addMapEntry(graph, c, null);
            }
        }

        for(int i=1; i<words.length; i++) {
            if(words[i-1]==words[i]) continue;
            if(!addMapping(graph, words[i-1], words[i], 0)) return false;
        }
        return true;
    }

    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      if(!initGraph(graph, words)) return "";
      
      Queue<Character> q = new LinkedList<Character>();
      Map<Character, Integer> indegree = new HashMap<>();
      for(Character key: graph.keySet()) {
        if(indegree.get(key)==null) {
            indegree.put(key, 0);
        }

        for(char c: graph.get(key)) { 
            Integer deg = indegree.get(c);
            if(deg == null) deg = 0;
            indegree.put(c, deg+1);
        }
      }

      int cnt=0;
      for(Character key: graph.keySet()) {
        if(indegree.get(key)==0) {
            q.add(key);
        }
      }
      StringBuilder builder = new StringBuilder();
      while(!q.isEmpty()) {
        Character c = q.poll();
        builder.append(c);

        for(char child: graph.get(c)) {
            int deg = indegree.get(child);
            indegree.put(child, deg-1);
            if(deg-1==0) {
                q.add(child);
            }
        }
      }

      for(Integer i: indegree.values()) {
        if(i!=0) return "";
      }

      String res = builder.toString();
      return res;
    }
}
