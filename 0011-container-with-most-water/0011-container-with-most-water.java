class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;

        int i = 0;
        int j = n - 1;

        while(i < j){
            int area = Math.min(height[i], height[j]) * (j - i);

            if(area > max) max = area;

            if(height[i] > height[j]) j--;
            else i++;
        }

        return max;
    }
}