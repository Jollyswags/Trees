class Solution {
    public int subsetXORSum(int[] nums) {
        return subs(nums,0,0);
        
    }
    public int subs(int nums[],int i, int xor)
    {
        if(i==nums.length)
            return xor;
        return subs(nums,i+1,xor^nums[i]) + subs(nums,i+1,xor);
    }
}