class KthLargest {

    private PriorityQueue<Integer> pq;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>(k);
        for(int i : nums){
            this.add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size() < size){
            pq.add(val);
        }
        else if (val > pq.peek()){
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */