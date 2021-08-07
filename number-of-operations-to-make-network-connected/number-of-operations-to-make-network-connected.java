class Solution {
    public int makeConnected(int n, int[][] grid) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0;i<grid.length;i++) uf.union(grid[i][0], grid[i][1]);    
        
        int no_link = -1;                                        
        for(int i=0;i<n;i++) if(uf.parent[i] == i) no_link++;   
        
        if (uf.count >= no_link) return no_link;                  
        else return -1;
    }
    
   
    class UnionFind{
        int[] parent;
        int count;
        
        public UnionFind(int n){
            parent = new int[n];
            for (int i =0;i<n;i++) parent[i] = i;
        }
        
        public void union(int x, int y){
            int find_x = find(x);
            int find_y = find(y);
            if (find_x != find_y){
                parent[find_x] = find_y;
                return;
            }
            count++;
        }
        
        public int find(int x){
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}