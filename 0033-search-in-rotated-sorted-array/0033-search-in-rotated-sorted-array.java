class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l + r)/2;

            if(target == nums[mid]) return mid;

            if(nums[mid] < nums[r]){
                //right right is sorted
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }
                else{
                    r = mid;
                }
            }
            else{
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
        }


        return -1;
    }
}