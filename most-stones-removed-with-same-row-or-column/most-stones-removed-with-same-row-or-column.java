class Solution {
   
        private Map<Integer, List<Integer>> rowMap = new HashMap<>();
    
    // key: col  Value: idx of stones s.t, each stone in col
    private Map<Integer, List<Integer>> colMap = new HashMap<>();
    
    private int[] parents;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        this.parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        
        for (int i = 0; i < n; i++) {
            int[] stone = stones[i];
            
            int r = stone[0], c = stone[1];
            rowMap.putIfAbsent(r, new ArrayList<>());
            rowMap.get(r).add(i);
            
            colMap.putIfAbsent(c, new ArrayList<>());
            colMap.get(c).add(i);
            
            union(i, rowMap.get(r).get(0));
            union(i, colMap.get(c).get(0));
        }
        
        int component = 0;
        for (int i = 0; i < n; i++) {
            if (i == find(i)) component++;
        }
        return n - component;
    }
    
    private void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        parents[iParent] = jParent;
    }
    
    private int find(int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
    
}