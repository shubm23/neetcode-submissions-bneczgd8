class TimeMap {
    private final HashMap<String, TreeMap<Integer, String>> timeEntryHashMap;

    public TimeMap() {
        this.timeEntryHashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeEntryHashMap.computeIfAbsent(key, (k) -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = timeEntryHashMap.get(key);

        if (map == null) return "";

        Map.Entry<Integer, String> entry = map.floorEntry(timestamp);
        
        return entry == null ? "" : entry.getValue();
    }
}