class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 1; i++){
            int start =  i + 1;
            int end = n - 1;

            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);
                    start++;
                    end--;
                } else if(sum < 0) start++;
                else end--;
            }
        }

        res = new ArrayList<>(new LinkedHashSet<>(res));

        return res;
    }
}