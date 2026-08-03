class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grpList = new HashMap<>();
        for (String str : strs) {
            String key = getGrpKey(str);
            grpList.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(grpList.values());
    }

    private String getGrpKey(String str) {
        int[] charSet = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charSet[str.charAt(i) - 'a']++;
        }
        return Arrays.toString(charSet);
    }
}