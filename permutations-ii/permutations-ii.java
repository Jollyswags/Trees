class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];
        helper(nums,0,nums.length,new ArrayList<>(),res,visited);
        return res;
    }
       public void helper(int nums[],int pos,int len,List<Integer> l,List<List<Integer>> res,boolean visited[])
    {
        if(l.size()==len)
        {
            if(!res.contains(l))
            res.add(new ArrayList<>(l));
            return;
        }
        if(pos==nums.length)
            return;
        for(int i=pos;i<nums.length;i++)
        {
          if(!visited[i])
          {
               visited[i]=true;
                l.add(nums[i]);
            helper(nums,pos,len,l,res,visited);
            l.remove(l.size()-1);
               visited[i]=false;
           }
        }
    }
}
                                          