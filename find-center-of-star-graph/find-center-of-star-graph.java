class Solution {
    public int findCenter(int[][] edges) {
        int i;
        HashMap<Integer,Integer> map =new HashMap();
        for(i=0;i<edges.length;i++)
        {
             map.put(edges[i][0],map.getOrDefault(edges[i][0],0)+1);
             map.put(edges[i][1],map.getOrDefault(edges[i][1],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
         
                             if(entry.getValue()==edges.length)
                                 return entry.getKey();
        return 0;
        
    }
    
}