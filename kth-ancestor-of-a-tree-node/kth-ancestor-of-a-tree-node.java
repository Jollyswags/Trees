class TreeAncestor {
   private int[] parent;
    private TreeMap<Integer, Integer>[] maps; // <node, <k, kth parent node>>: Save records with maps
    
    public TreeAncestor(int n, int[] parent) {
        
        this.parent = parent;
        this.maps = new TreeMap[n];
        
        for (int i = 0; i < n; i++)
            maps[i] = new TreeMap<>();
    }
    
    public int getKthAncestor(int node, int k) {
        
        if (k == 0)
            return node;
        
        if (parent[node] < 0)
            return -1;
        
        Integer floorKey = maps[node].floorKey(k);
        
        if (floorKey == null)
        {
            int parentNode = getKthAncestor(parent[node], k-1);
            
            if (parentNode >= 0)
                maps[node].put(k, parentNode);
            
            return parentNode;
        }
        else
        {
            int parentNode = maps[node].get(floorKey);
            
            if (floorKey < k)
            {
                parentNode = getKthAncestor(parentNode, k - floorKey);
                
                if (parentNode >= 0)
                    maps[node].put(k, parentNode);
            }
            
            return parentNode;
        }
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */