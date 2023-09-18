class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            } 
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        int[] res = new int[k];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i).getKey();
        }

        return res;
          


    }
}