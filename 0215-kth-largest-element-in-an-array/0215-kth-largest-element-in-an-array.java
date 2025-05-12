class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num: nums){
            pq.offer(num);
        }
        k--;
        while(k != 0){
            k--;
            pq.poll();
        }

        return pq.peek();
    }
}