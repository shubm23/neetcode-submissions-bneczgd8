class TimeEntry {
    String value;
    int timeStamp;

    public TimeEntry(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}

class TimeMap {
    private final HashMap<String, List<TimeEntry>> timeEntryHashMap = new HashMap<String, List<TimeEntry>>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        timeEntryHashMap.computeIfAbsent(key, (k) -> new ArrayList<>()).add(new TimeEntry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeEntry> timeEntries = timeEntryHashMap.getOrDefault(key, new ArrayList<>());
        for (TimeEntry timeEntry : timeEntries.reversed()) {
            if (timeEntry.timeStamp <= timestamp) {
                return timeEntry.value;
            }
        }

        return "";
    }
}
