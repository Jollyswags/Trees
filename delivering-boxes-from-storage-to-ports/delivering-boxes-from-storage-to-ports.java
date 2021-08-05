class Solution {
   int dp(int[][] arr,int boxLimit,int weightLimit)
{
	int n=arr.length;
	int[] port=new int[n+1];
	int[] weight=new int[n+1];
	int[] memo=new int[n+1];
	weight[n-1]=arr[n-1][1];
	for(int i=n-2;i>=0;--i)
	{
		port[i]=port[i+1]+((arr[i][0]!=arr[i+1][0])?1:0);
		weight[i]=weight[i+1]+arr[i][1];
	}
	Deque<int[]> q=new LinkedList<int[]>();
	q.add(new int[]{n,-1});
	for(int i=n-1;i>=0;--i)
	{
		memo[i]=2+memo[i+1];
		while(!q.isEmpty()&&(q.peekFirst()[0]-i>boxLimit||weight[i]-weight[q.peekFirst()[0]]>weightLimit))
			q.removeFirst();
		if(!q.isEmpty())
		{
			int j=q.peek()[0];
			int temp=port[i]-port[j-1]+memo[j];
			memo[i]=Math.min(memo[i],2+temp);                    
		}
		while(!q.isEmpty()&&q.peekLast()[1]>=memo[i]-(i>0?port[i-1]:0))
			q.removeLast();
		q.add(new int[]{i,memo[i]-(i>0?port[i-1]:0)});
	}
	return memo[0];
}
public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) 
{
	return dp(boxes,maxBoxes,maxWeight);
}
}