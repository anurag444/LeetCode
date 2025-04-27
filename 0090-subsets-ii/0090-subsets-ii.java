class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, 0);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int idx){
        //add the temp to res, and we have to add by creating new list due to how java handles references
        // by using new java will create a copy, if we not use it then everytime list is updated, it will
        // be updated in the res as well.
        res.add(new ArrayList<>(list));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);

            backtrack(res, list, nums, i + 1);

            list.remove(list.size() - 1);
        } 
    }
}