class Solution {
    public int singleNumber(int[] nums) {
        //base case if size is 1 
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        Set<Integer> set = new HashSet<>();
        
        for(int i: nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        
        Iterator<Integer> i = set.iterator();
        
        return i.next();
    }
}