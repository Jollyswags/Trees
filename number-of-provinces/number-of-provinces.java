class Solution {
   private class DisjointSets { 
    private int parent[];
    private int count; 
    
    public DisjointSets(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;
        count = n;
    }
    
    public int find(int node) {
        if(parent[node] ==node)
            return node;
            else return find(parent[node]);
    }
    
    public void unionSet(int nodeOne, int nodeTwo) {
        int set1 = find(nodeOne);
        int set2 = find(nodeTwo);
        if (set1 != set2) {
            parent[set1] = set2;
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
 }
    
  public int findCircleNum(int[] []isConnected) {
        DisjointSets unionFind = new DisjointSets(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.unionSet(i, j);
                }
            }
        }
        
        return unionFind.getCount();
    }
}