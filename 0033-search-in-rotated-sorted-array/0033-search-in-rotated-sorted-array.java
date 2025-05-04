class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int mid = 0;

        while(left <= right){
            mid = (left + right)/2;

            if(nums[mid] == target) return mid;
            else if(nums[left] <= target && nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }


        return -1;
    }
}