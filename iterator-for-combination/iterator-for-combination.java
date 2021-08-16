class CombinationIterator {
 Queue<String> q;
    public CombinationIterator(String characters, int combinationLength) {
        q=new ArrayDeque<>();
        getsubs(characters,0,combinationLength, new StringBuilder());
    }
    
    public void getsubs(String str,int idx,int len, StringBuilder sb)
    {
        if(sb.length()==len)
            q.add(sb.toString());
        if(idx==str.length())
            return;
        for(int i=idx;i<str.length();i++)
        {
            sb.append(str.charAt(i));
            getsubs(str,i+1,len,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    
    public String next() {
        if(!q.isEmpty())
            return q.remove();
        return null;
        
    }
    
    public boolean hasNext() {
        return (!q.isEmpty());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */