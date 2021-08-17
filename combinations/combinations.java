class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       backtrack(new ArrayList(),1,k,n);
        return ans;  
    }
     void backtrack(List <Integer> temp, int idx,int k,int l)
    {

        if(temp.size() == k)
        {
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int i = idx;i<=l;i++)
        {
            temp.add(i);
            backtrack(temp,i+1,k,l);
            temp.remove(temp.size()-1);
            
            
        }
    }

}