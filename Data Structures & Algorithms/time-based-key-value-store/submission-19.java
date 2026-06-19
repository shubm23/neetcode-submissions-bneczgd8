class TimeMap {
    private final Map<String, TreeMap<Integer, String>> cache = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        if (cache.containsKey(key)) {
            cache.get(key).put(timestamp, value);
            return;
        }
        cache.put(key, new TreeMap<>() {
            {
                put(timestamp, value);
            }
        });
    }

    public String get(String key, int timestamp) {
        if (!cache.containsKey(key)) return "";
        TreeMap<Integer, String> treeMap = cache.get(key);
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
