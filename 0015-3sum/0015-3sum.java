class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];

            //from here we do two sum on sorted array

            int low = i + 1;
            int high = n - 1;


            while(low < high){
                int sum = nums[low] + nums[high];

                if(sum == target){
                    //we found the values
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    while(low < high && nums[high] == nums[high - 1])high--;
                    high--;
                    low++;
                }
                else if(sum > target){
                    high--;
                }
                else{
                    low++;
                }
            }
        }

        return res;
    }
}