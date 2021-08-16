class Solution {
    int count=0;
    public int countArrangement(int N) {
        boolean v[]=new boolean[N+1];
        calculate(N,1,v);
        return count;
    }
    public void calculate(int N, int pos,boolean v[])
    {
        if(pos>N)
            count++;
        for(int i=1;i<=N;i++)
        {
            if(!v[i] && (pos%i==0 || i%pos==0))
            {
                v[i]=true;
                calculate(N,pos+1,v);
                v[i]=false;
            }
        }
    }
}