class Solution {
    List<List<Integer>> resList = new ArrayList<>();
  List<Integer> res = new ArrayList<>();
  int[] nums;
  public List<List<Integer>> findSubsequences(int[] nums) {
    this.nums = nums;
    backtracking(0);
    return resList;
  }
  
  public void backtracking(int startIndex) {
    if(res.size() > 1) {
      resList.add(new ArrayList<>(res));
    }
    Set<Integer> set = new HashSet<>();
    for(int i = startIndex; i < nums.length; i++) {
      // number is smaller, skip
      if(res.size() > 0 && nums[i] < res.get(res.size() - 1).intValue()) continue;      
      if(set.contains(nums[i])) {
        // number is used at the same level, skip
        continue;
      } else {
        // add to set to avoid duplicates later
        set.add(nums[i]);
      }

      res.add(nums[i]);
      backtracking(i + 1);
      res.remove(res.size() - 1);
    }
  }  
}