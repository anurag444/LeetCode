class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1,end=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            end = Math.max(end,piles[i]);
        }
        while(start<end){
            int mid = (start+end)/2;
            int sum = 0;
            for(int i=0;i<piles.length;i++){
                sum += Math.ceil((double)piles[i]/(double)mid);
            }
            if(sum<=h){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}