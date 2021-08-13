class Solution {
     public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    Map<Integer, List<double[]>> graph = buildGraph(edges, succProb, n);
    double res = dijkstra(start, end, graph, n);
    return res;
  }
    
  public double dijkstra(int start, int end, Map<Integer, List<double[]>> graph, int n) {
    double[] prob = new double[n];
    Arrays.fill(prob, -1);
    prob[start] = 1;
    
    PriorityQueue<double[]> pq = new PriorityQueue<double[]>((w1, w2) -> {
      return w2[1] > w1[1] ? 1 : -1; // max pq because we are looking for max probablity (normal Dijkstras sorts by min weight to get lowest cost)
    });
    pq.offer(new double[]{start, 1}); // 100% chance to visit start node starting from start node
    
    while(!pq.isEmpty()) {
      double[] node = pq.poll();
      double dest = node[0];
      double destWeight = node[1];
      
      List<double[]> neighbors = graph.get((int) dest);
      
      for(double[] neighbor : neighbors) {
        double neighborNode = neighbor[0];
        double neighborWeight = neighbor[1];
        
        double chance = prob[(int)dest] * neighborWeight;
        
        // if neighbor was never visited, it's cost is the default value of -1
        // if neighbor probability is less than the current chance, we can replace it with a better path
        if(chance > prob[(int)neighborNode] || prob[(int)dest] == -1) {
          prob[(int) neighborNode] = chance;
          pq.offer(new double[]{neighborNode, chance});
        }
      }
    }    
    return prob[end] == -1 ? 0 : prob[end]; // -1 means there is no path from start -> end
  }
  
  public Map<Integer, List<double[]>> buildGraph(int[][] edges, double[] succProb, int n) {
    Map<Integer, List<double[]>> graph = new HashMap<>();
    
    for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
    
    int i = 0;
    for(int[] edge : edges) {
      int src = edge[0];
      int dest = edge[1];
      
      graph.get(src).add(new double[]{dest, succProb[i]});
      graph.get(dest).add(new double[]{src, succProb[i]});
      i++;
    }
    
    return graph;
  }
}