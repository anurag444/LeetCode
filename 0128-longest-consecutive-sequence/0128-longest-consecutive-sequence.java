class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int max = 0;

        for(int i= 0; i < n; i++){
            int len = 1;
            int num = nums[i];
            while(set.contains(num + 1)){
                len++;
                set.remove(num + 1);
                num++;
            }
            num = nums[i];
            while(set.contains(num - 1)){
                len++;
                set.remove(num - 1);
                num--;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}