class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = stones.length;
        
        if(n == 1) return stones[0];
        
        for(int num: stones){
            heap.offer(num);
        }
        while(heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();
            
            if(x > y){
                heap.offer(x - y);
            }
        }
        
        if(heap.size() == 1) return heap.peek();
        
        
        return 0;
    }
}