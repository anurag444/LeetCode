class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, 0);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int idx){
        //add the temp to res, and we have to add by creating new list due to java feature
        res.add(new ArrayList<>(list));

        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);

            backtrack(res, list, nums, i + 1);

            list.remove(list.size() - 1);
        } 
    }
    
    
}