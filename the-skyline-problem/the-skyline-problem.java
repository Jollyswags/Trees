class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 1. Build sorted lines by x first then by y
        List<Line> lines = buildSortedLines(buildings);
        
        // 2. TreeMap to process overlapped buildings by store <height, count> pairs
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int curHeight = 0, prevHeight = 0;
        for (Line line : lines) {
            // Update TreeMap
            if (line.y < 0) { // If left line, add the height to TreeMap.
                int count = map.getOrDefault(-line.y, 0) + 1;
                map.put(-line.y, count);
            } else {  // If right line, check whether height exists.
                int count = map.get(line.y) - 1;
                if (count > 0) {
                    map.put(line.y, count);
                } else {
                    // If count == 0, then the line is the last coordinate left line, remove it.
                    map.remove(line.y);
                }
            }
            // Update skyline if curHeight != prevHeight
            curHeight = map.lastKey();
            if (curHeight != prevHeight) {
                res.add(Arrays.asList(line.x, curHeight));
            }
            prevHeight = curHeight;
        }
        return res;
    }
    
    private List<Line> buildSortedLines(int[][] buildings) {
        List<Line> lines = new ArrayList<>(buildings.length * 2);
        for (int[] building : buildings) {
            lines.add(new Line(building[0], -building[2])); // Add left line x and -height
            lines.add(new Line(building[1], building[2]));  // Add right line x and height
        }
        Collections.sort(lines, (l1, l2) -> {
            int comp = Integer.compare(l1.x, l2.x); // Sort by x from left to right first
            if (comp != 0) {
                return comp;
            } else {
                return Integer.compare(l1.y, l2.y); // Sort by y from low to high if x same
            }
        });
        return lines;
    }
    
    class Line {
        int x, y;
        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}