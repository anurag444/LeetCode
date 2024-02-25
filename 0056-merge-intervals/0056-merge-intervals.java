class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        
        int size = intervals.length;
        if(size == 1) return intervals;
        
        //first, add to the list
        int f1 = intervals[0][0];
        int f2 = intervals[0][1];
            
        int s1 = intervals[1][0];
        int s2 = intervals[1][1];
        
        int index = 1;
        
        if(f2 < s1){
            res.add(new int[]{f1, f2});
        }
        //merging
        else if(f2 >= s1){
            res.add(new int[]{Math.min(f1, s1), Math.max(f2, s2)});
            index = 2;
        }
        
        
        for(int i = index; i < size; i++){
            int x1 = res.get(res.size() - 1)[0];
            int x2 = res.get(res.size() - 1)[1];
            
            int y1 = intervals[i][0];
            int y2 = intervals[i][1];
            
            //case 1 - no merging
            if(x2 < y1){
                res.add(new int[]{y1, y2});
            }
            //merging
            else if(x2 >= y1){
                //remove from the res
                res.remove(res.size() - 1);
                res.add(new int[]{Math.min(x1, y1), Math.max(x2, y2)});
            }
        }
        
        int n = res.size();
        int[][] out = new int[n][2];
        
        res.toArray(out);
        
        return out;
    }
}