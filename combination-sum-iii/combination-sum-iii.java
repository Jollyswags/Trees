class Solution {
List<List<Integer>> ans = new ArrayList<>();
    void backtrack(List <Integer> temp, int idx,int sum,int size,int target)
    {

        if(sum > target )
            return ;
        if(sum == target && (temp.size() == size))
        {
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int i = idx;i<=9;i++)
        {
            temp.add(i);
            backtrack(temp,i+1,sum+i,size,target);
            temp.remove(temp.size()-1);
            
            
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0)
            return ans;
        backtrack(new ArrayList(),1,0,k,n);
        return ans;
        
        
    }
}