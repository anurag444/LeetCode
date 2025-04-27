class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, new HashSet<Integer>());

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, Set<Integer> set){
        //add the temp to res, and we have to add by creating new list due to how java handles references
        // by using new java will create a copy, if we not use it then everytime list is updated, it will
        // be updated in the res as well.
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(i) || i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) continue;
            
            list.add(nums[i]);
            set.add(i);

            backtrack(res, list, nums, set);

            list.remove(list.size() - 1);
            set.remove(i);
        } 
    }
}