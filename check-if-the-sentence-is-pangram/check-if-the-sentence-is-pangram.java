class Solution {
    public boolean checkIfPangram(String sentence) {
        sentence=sentence.toLowerCase();
        int f=1;
        Map<Character,Integer> map=new HashMap();
        int i;
        for(i=0;i<sentence.length();i++)
        {
            
            map.put(sentence.charAt(i),map.getOrDefault(sentence.charAt(i),0)+1);
        }
        for(char c='a'; c<='z';c++)
        {
            if(!map.containsKey(c))
                return false;
                
        }
        return true;
     
      
        
    }
}