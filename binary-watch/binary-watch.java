class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = new int[] {8,4,2,1};
        int[] mins = new int[] {32,16,8,4,2,1};
        
        Set<String> res = new HashSet<>();
        
        for(int i=0;i<=turnedOn;i++)
        {
            List<Integer> list1 = generateTime(hours,i);
            List<Integer> list2 = generateTime(mins,turnedOn-i);
            for(int h : list1)
            {
                if(h >= 12)
                    continue;
                for(int min : list2)
                {
                    if(min >= 60)
                        continue;
                    res.add(h+":"+(min<10 ? "0"+min : min));
                }
            }
        }
        return new ArrayList(res);
    }
    List<Integer> generateTime(int[] nums,int count)
    {
        List<Integer> res = new ArrayList<>();
        recursion(nums,count,0,0,res);
        return res;
    }
    void recursion(int[] nums,int count ,int sum,int pos,List<Integer> res)
    {
        if(count == 0)
        {
            res.add(sum);
            return ;
        }
        for(int i=pos;i<nums.length;i++)
        {
            recursion(nums,count-1,sum+nums[i],i+1,res);
        }
    }
}