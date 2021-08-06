class Solution {
    public int findJudge(int n, int[][] trust) {
         int i;
        if(n==1)
            return 1;
        HashMap<Integer,Integer> map =new HashMap();
        for(i=0;i<trust.length;i++)
        {
          
             map.put(trust[i][1],map.getOrDefault(trust[i][1],0)+1);
        }
         HashMap<Integer,Integer> prev =new HashMap();
        for(i=0;i<trust.length;i++)
        {
          
             prev.put(trust[i][0],map.getOrDefault(trust[i][0],0)+1);
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
         
         if(entry.getValue()==n-1 && !prev.containsKey(entry.getKey()))
                                 return entry.getKey();
        return -1;
        
    }
        
    }
