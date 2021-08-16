class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(s.length());
        permuteUtil(s, ans, sb, 0);
        return ans;
    }
    
	//this function generates all the permuations
    public void permuteUtil(String s, List<String> ans, StringBuilder sb, int index) {
        //if we have traversed all the elements then add it to result
		if(index == s.length()) {
            ans.add(sb.toString());
            return;
        }
        int c = (int)s.charAt(index);
		
		//if the current character is an alphabet then reverse the case of character and add to permutation
        if(c >= 97 && c <=122){ 
            sb.append((char)(c-32));
            permuteUtil(s, ans, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(c>=65 && c<=90) {
            sb.append((char)(c+32));
            permuteUtil(s, ans, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
		
		//every character whether an alphabet or not needs to be added as it is to form a permutation
        sb.append(s.charAt(index));
        permuteUtil(s, ans, sb, index+1);
        sb.deleteCharAt(sb.length()-1);
        return;
    }
}