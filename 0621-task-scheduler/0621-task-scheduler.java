class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1 freq array 
        int[] freq = new int[26];

        for(char c: tasks){
            freq[c - 'A']++;
        }

        //create PQ and add the freq > 0
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i : freq){
            if(i > 0){
                pq.offer(i);
            }
        }

        //create a queue
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int count = pq.poll() - 1;

                if(count != 0){
                    q.offer(new Pair(count, time + n));
                }
            }

            if(!q.isEmpty() && q.peek().getValue() == time){
                pq.offer(q.poll().getKey());
            }

        }

        return time;
    }
}