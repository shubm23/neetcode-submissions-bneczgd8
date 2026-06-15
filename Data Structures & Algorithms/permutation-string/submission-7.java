class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.merge(s1.charAt(i), 1, Integer::sum);
            s2Map.merge(s2.charAt(i), 1, Integer::sum);
        }

        if (checkKeys(s1Map, s2Map))
            return true;
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            s2Map.merge(s2.charAt(r), 1, Integer::sum);
            s2Map.compute(s2.charAt(l), (key, val) -> val == null || val == 0 ? 0 : val - 1);
            if (s2Map.get(s2.charAt(l)) == 0) {
                s2Map.remove(s2.charAt(l));
            }
            l++;
            if (checkKeys(s1Map, s2Map))
                return true;
        }
        return false;
    }

    private boolean checkKeys(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map) {
        Set<Character> keys1 = s1Map.keySet();
        Set<Character> keys2 = s2Map.keySet();
        if (keys2.size() != keys1.size())
            return false;
        for (Character key : keys1) {
            if (!s1Map.get(key).equals(s2Map.get(key)))
                return false;
        }
        return true;
    }
}
