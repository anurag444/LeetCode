class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hashMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timeValueMap = hashMap.get(key);

        Integer floorTimestamp = timeValueMap.floorKey(timestamp);

        return (floorTimestamp == null) ? "" : timeValueMap.get(floorTimestamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */