class Solution {
    int ans;
    public int maxLength(List<String> arr) {
        HashSet<Character> h = new HashSet<Character>();
        ans = 0;
        find(arr,  0, 0, h);
        return ans;
    }
    
    public void find(List<String> arr, int pos, int len, HashSet<Character> h){
    	if(pos == arr.size()) {
    		if(ans < len)
    			ans = len;
    		return;
    	}
        find(arr, pos + 1, len, h);
        HashSet<Character> hh = new HashSet<>(h);
        for(int i = 0; i < arr.get(pos).length(); i++){
            if(hh.contains(arr.get(pos).charAt(i))){
                find(arr, pos + 1, len, hh);
                return;
            }
            hh.add(arr.get(pos).charAt(i));
        }
        find(arr, pos + 1, len + arr.get(pos).length(), hh);
    }
}