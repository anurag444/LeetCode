class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), candidates, 0, 0, target);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int idx, int sum, int target){
        //add the temp to res, and we have to add by creating new list due to how java handles references
        // by using new java will create a copy, if we not use it then everytime list is updated, it will
        // be updated in the res as well.
        if(sum == target){
            res.add(new ArrayList<>(list));
        }
        if(sum > target) return;

        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);

            backtrack(res, list, nums, i, sum + nums[i], target);

            list.remove(list.size() - 1);
        } 
    }
}