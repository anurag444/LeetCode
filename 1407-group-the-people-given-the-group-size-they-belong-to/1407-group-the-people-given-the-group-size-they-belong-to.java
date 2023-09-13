class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < groupSizes.length; i++){
            int key = groupSizes[i];

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);

            if(map.get(key).size() == key){
                res.add(map.get(key));
                map.remove(key);
            }
        }

        return res;
    }
}