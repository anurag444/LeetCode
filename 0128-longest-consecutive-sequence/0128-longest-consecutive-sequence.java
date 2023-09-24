class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int max = 0;
        int longest = 0, ans = 0;

        for(int num : set){
            //check if the number is not between the sequence
            if(!set.contains(num - 1)){
                max = 1;
                longest = num;
                while(set.contains(longest + 1)){
                    max += 1;
                    longest += 1;
                }
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }
}