class Solution {
        private List<List<Integer>> graph;
    private int[] solution;
    private String labels;
    private Set<Integer> visited;
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++) graph.add(new ArrayList());
        
        for(int i = 0; i < edges.length; i ++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        this.graph = graph;
        this.solution = new int[n];
        this.labels = labels;
        this.visited = new HashSet();
        
        traverse(0);
        return solution;
    }
    
    private Map<Character, Integer> traverse(int node) {
        visited.add(node);
        char nodeLabel = labels.charAt(node);
        List<Integer> neighbors = graph.get(node);
        
        Map<Character, Integer> nodeMap = new HashMap();
        nodeMap.put(nodeLabel, 1);
        
        for(int neigh: neighbors) {
            if(!visited.contains(neigh)) {
                //Its a child!
                Map<Character, Integer> childMap = traverse(neigh);
                for(Character c: childMap.keySet()) {
                    nodeMap.put(c, nodeMap.getOrDefault(c, 0) + childMap.get(c));
                }
            }
        }
        
        solution[node] = nodeMap.get(nodeLabel);
        return nodeMap;
    }
}