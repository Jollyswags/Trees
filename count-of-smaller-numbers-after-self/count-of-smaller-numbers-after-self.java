class Solution {
    
    class SegmentTree{
        int[] tree;
        int n;
        int treeSize;
        
        SegmentTree(){
            n = (int) Math.pow(10, 5)+1;
            int temp = (int)(Math.ceil(Math.log(n)/Math.log(2)));
            treeSize = (int) (2*Math.pow(2, temp) - 1);
            
            tree = new int[treeSize];
        }
        
        void add(int val){
            add(0, 0, n-1, val);
        }
        
        void add(int node, int start, int end, int val){
            if(start == end && start == val){
                tree[node]++;
            }
            else{
                int mid = start + (end - start)/2;
                
                if(val <= mid){
                    add(2*node+1, start, mid, val);
                }
                else{
                    add(2*node+2, mid+1, end, val);
                }
                
                tree[node] = tree[2*node+1] + tree[2*node+2];
            }
        }
        
        int query(int left, int right){
            return query(0, 0, n-1, left, right);
        }
        
        int query(int node, int start, int end, int left, int right){
            if(end < left || start > right) return 0;
            if(left<= start && end<=right){
                return tree[node];
            }
            
            int mid = start + (end - start)/2;
            
            int l = query(2*node+1, start, mid, left, right);
            int r = query(2*node+2, mid+1, end, left, right);
            
            return l+r;
        }
    }
    
    public List<Integer> countSmaller(int[] nums){
        int n = nums.length;
        
        int constantVal = (int) Math.pow(10, 4);
        
        for(int i=0;i<n;i++){
            nums[i] += constantVal;
        }
        
        SegmentTree segTree = new SegmentTree();
        int[] result = new int[n];
        
        for(int i=n-1;i>-1;i--){
            int val = nums[i];
            
            int count = segTree.query(0, val-1);
            
            result[i] = count;
            
            segTree.add(nums[i]);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(int val : result){
            resultList.add(val);
        }
        return resultList;
    }
}