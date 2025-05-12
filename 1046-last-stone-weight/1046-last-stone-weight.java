class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num: stones){
            pq.offer(num);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            int diff = y - x;

            if(diff > 0){
                pq.offer(diff);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}