class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int end = 0;

        for(int pile : piles){
            end = Math.max(end, pile);
        }

        int start = 1;

        int mid = 0;

        while(start < end){
            mid = (start + end)/2;
            int time = timeToEat(piles, mid);
            if(time <= h){
                end = mid;
            }
            else{
                start = mid + 1;
            }

        }

        return end;
    }

    public int timeToEat(int[] piles, int speed){
        int time = 0;

        for(int pile: piles){
            time += Math.ceil(((double)pile/(double)speed));
        }

        return time;
    }
}