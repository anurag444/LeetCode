class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(res, candidates, target, list, 0, candidates.length);

        return res;
    }

    public void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> list,  int i, int n){
        if(0 == target){
            res.add(new ArrayList<>(list));
            return;
        }
        //base case
        if(i >= n) return;

        

        if(target < 0) return;

        //we choose the number
        list.add(candidates[i]);
        helper(res, candidates, target - candidates[i], list, i, n);

        list.remove(list.size() - 1);
        //we dont choose the current val
        helper(res, candidates, target, list, i + 1, n);

        
    }
}