class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for(int num : piles){
            high = Math.max(high, num);
            low = Math.min(low, num);
        }

        int mid = 0;

        low = 1;

        while(low <= high){
            mid = (low + high)/2;

            int sum = 0;

            for(int num : piles){
                sum += (int)Math.ceil((double) num/(double)mid);
            }


            if(sum <= h) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}