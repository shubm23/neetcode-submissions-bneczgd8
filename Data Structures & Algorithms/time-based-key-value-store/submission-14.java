class TimeMap {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        return !Objects.isNull(treeMap) && !treeMap.isEmpty() && treeMap.floorEntry(timestamp) != null ? treeMap.floorEntry(timestamp).getValue() : "";
    }
}