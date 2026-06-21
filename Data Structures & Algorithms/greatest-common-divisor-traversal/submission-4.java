class DSU {
    Map<Integer, Integer> mp;
    public DSU() {
        mp = new HashMap<>();
    }

    public void merge(int x, int y) {        
        int px = getParent(x);
        int py = getParent(y);
        if(px==py) return;
        int szx = mp.get(px);
        int szy = mp.get(py);
        if (szx<=szy) {
            szx+=szy;
            mp.put(py, px);
            mp.put(px, szx);
        } else {
            szy+=szx;
            mp.put(px, py);
            mp.put(py, szy);
        }
    }

    public int getParent(int x) {
        add(x);
        int par  = mp.get(x);
        if(par<0) return x;
        par = getParent(par);
        mp.put(x, par);
        return par; 
    }

    public void add(int x) {
        if(!mp.containsKey(x)) mp.put(x, -1);
    }

    public int groupSize() {
        return mp.values()
            .stream()
            .filter(val-> val<0)
            .toList()
            .size();
    }
    
}
class Solution {

    public boolean canTraverseAllPairs(int[] nums) {
        boolean[] isPrime = new boolean[100000];
        Arrays.fill(isPrime, true);
        isPrime[0]=isPrime[1]=false;
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<isPrime.length;i++) {
            if(isPrime[i]==false) continue;
            primes.add(i);
            for(int j=2*i;j<isPrime.length;j+=i) {
                isPrime[j] = false;
            }
        }

        DSU dsu = new DSU();
        for(int i: nums) {
            if(i==1) return false;
            List<Integer> curr = new ArrayList<>();
            int prev=-1;
            for(int j: primes) {
                if(i%j==0) {
                    curr.add(j);
                    dsu.add(j);
                    if(prev!=-1) dsu.merge(prev, j);
                    prev = j;
                }
                while(i>1 && i%j==0) i/=j;
            }
        }
        return dsu.groupSize()<=1;
    }
}