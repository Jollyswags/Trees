class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set=new HashSet<>();
        boolean[] visited=new boolean[tiles.length()];
        helper(tiles,"",set,visited);
        return set.size();
        
    }
    public void helper(String tiles, String temp, HashSet<String> set, boolean visited[])
    {
        if(temp.length()!=0)
            set.add(temp);
        for(int i=0;i<tiles.length();i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                helper(tiles,temp+tiles.charAt(i),set,visited);
                visited[i]=false;
            }
        }
    }
}