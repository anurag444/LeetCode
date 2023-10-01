class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int i = 0, j = height.length - 1;

        int maxL = height[i]; 
        int maxR = height[j];


        while(i < j){
            if(maxL < maxR){
                i++;
                maxL = Math.max(maxL, height[i]);
                sum += maxL - height[i];
            }else{
                j--;
                maxR = Math.max(maxR, height[j]);
                sum += maxR - height[j];
            }
        }

        return sum;
    }
}