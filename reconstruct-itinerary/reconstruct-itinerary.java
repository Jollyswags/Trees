class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res=new ArrayList();
        Map<String, List<String>> graph = new HashMap();
        Deque<String> stack = new ArrayDeque();
        // build graph
        for (List<String> edge : tickets){
            List<String> neighbours = graph.getOrDefault(edge.get(0), new ArrayList());
            neighbours.add(edge.get(1));
            graph.put(edge.get(0), neighbours);
        }
        // sort adj list in ascn
        for (List<String> values : graph.values()){
           Collections.sort(values, Comparator.reverseOrder()); 
        }
        
        stack.offerLast("JFK");
        while(!stack.isEmpty()){
            String lastEdge = stack.peekLast();
            if (!graph.containsKey(lastEdge) || graph.get(lastEdge).size() == 0){ // no neighbours on this, we can pop it off and add to our result
                stack.pollLast();
                res.add(lastEdge);
            } else {
                // push the first neighbour onto the stack , remove that edge from our adj list
                List<String> adj = graph.get(lastEdge);
                String s = adj.get(adj.size() - 1);
                stack.offerLast(s);
                graph.get(lastEdge).remove(adj.size() - 1);
            }
        }
    
        Collections.reverse(res);
        return res;
    }
}