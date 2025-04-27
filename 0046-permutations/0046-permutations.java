class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums){
        //add the temp to res, and we have to add by creating new list due to how java handles references
        // by using new java will create a copy, if we not use it then everytime list is updated, it will
        // be updated in the res as well.
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);

            backtrack(res, list, nums);

            list.remove(list.size() - 1);
        } 
    }
}