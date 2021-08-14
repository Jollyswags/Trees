enum Colors {
    ROOT, RED, BLUE
}

class Path {
    int idx;
    Colors color;
    int val;
    
    Path (int idx, Colors color, int val) {
        this.idx = idx;
        this.color = color;
        this.val = val;
    }
}

class Solution {    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>> redAjdList = new HashMap<>();
        Map<Integer, List<Integer>> blueAjdList = new HashMap<>();
        
        for (int[] i : red_edges) {
            redAjdList.putIfAbsent(i[0], new ArrayList<>());
            redAjdList.get(i[0]).add(i[1]);
        }
        
        for (int[] i : blue_edges) {
            blueAjdList.putIfAbsent(i[0], new ArrayList<>());
            blueAjdList.get(i[0]).add(i[1]);
        }
        
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, -1);
        
        Queue<Path> q = new LinkedList<>();
        q.offer(new Path(0, Colors.ROOT, 0));
        
        Set<String> visited = new HashSet<>();
        
        while(!q.isEmpty()) {
                Path p = q.poll();

                String sequence = p.idx + " " + p.color;

                if (visited.contains(sequence)) continue;

                visited.add(sequence);
                
                if (shortestPath[p.idx] == - 1) shortestPath[p.idx] = p.val;

                if ((p.color == Colors.ROOT || p.color == Colors.BLUE) && redAjdList.containsKey(p.idx)) {
                    for (Integer idx : redAjdList.get(p.idx)) {
                        q.offer(new Path(idx, Colors.RED, p.val + 1));
                    }
                }


                if ((p.color == Colors.ROOT || p.color == Colors.RED) && blueAjdList.containsKey(p.idx)) {
                    for (Integer idx : blueAjdList.get(p.idx)) {
                        q.offer(new Path(idx, Colors.BLUE, p.val + 1));
                    }
                }
        }
        
        return shortestPath;
    }
}