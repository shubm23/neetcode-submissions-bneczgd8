class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Count = new HashMap<>(), windowCount = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Count.compute(s1.charAt(i), (k, v) -> {
                return v == null ? 1 : v + 1;
            });
            windowCount.compute(s2.charAt(i), (k, v) -> {
                return v == null ? 1 : v + 1;
            });
        }

        if (matches(s1Count, windowCount)) return true;

        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {
            windowCount.compute(s2.charAt(r), (k, v) -> v == null ? 1 : v + 1);

            windowCount.compute(s2.charAt(l), (k, v) -> v == null || v == 0 ? 0 : v - 1);

            if (windowCount.get(s2.charAt(l)) == 0) {
                windowCount.remove(s2.charAt(l));
            }
            l++;

            if (matches(s1Count, windowCount)) return true;
        }

        return false;
    }

    private boolean matches(Map<Character, Integer> obj1, Map<Character, Integer> obj2) {
        Set<Character> key1Set = obj1.keySet();
        Set<Character> key2Set = obj2.keySet();
        if (key1Set.size() != key2Set.size()) return false;
        for (Character key : key1Set) {
            if (!obj1.get(key).equals(obj2.get(key))) return false;
        }
        return true;
    }
}
