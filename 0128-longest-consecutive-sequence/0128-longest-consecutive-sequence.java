class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int res = 0;

        for(int num: nums){
            map.put(num, false);
        }


        for(Map.Entry<Integer, Boolean> entry : map.entrySet()){
            //check if value is already covered
            int val = entry.getKey();
            if(map.get(val)) continue;

            int sum = 1;
            int temp = val;
            while(map.containsKey(val + 1)){
                sum++;
                map.put(val + 1, true);
                val = val + 1;
            }

            while(map.containsKey(temp - 1)){
                sum++;
                map.put(temp - 1, true);
                temp = temp - 1;
            }

            if(sum > res) res = sum;
        }

        return res;
    }
}