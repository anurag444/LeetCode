class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index){
        if(target == 0){
            res.add(new ArrayList<>(list));
        }

        if(target < 0) return;

        for(int i = index; i < candidates.length; i++){
            list.add(candidates[i]);

            helper(candidates, target - candidates[i], res, list, i);
            list.remove(list.size() - 1);
            
        }
    }
}