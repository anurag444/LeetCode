class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        int n = points.length;
        Map<Double, Integer> dist = new HashMap<>();
        for(int i = 0; i < n; i++){
            //calc dist and add to dist arr

            double leng = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));

            dist.put(leng, i);
        }

        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(Map.Entry<Double, Integer> entry: dist.entrySet()){
            pq.offer(entry.getKey());

            if(pq.size() > k){
                pq.poll();
            }
        }

        Iterator<Double> it = pq.iterator();
        int i = 0;

        while(it.hasNext()){
            Double d = it.next();

            int idx = dist.get(d);

            res[i] = points[idx];
            i++;
        }

        return res;
    }
}