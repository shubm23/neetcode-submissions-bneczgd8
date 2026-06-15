class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grpList = new HashMap<>();
        for (String str : strs) {
            String key = generateGrpKey(str);
            grpList.computeIfAbsent(key, (k) -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(grpList.values());
    }

    private String generateGrpKey(String str) {
        int[] chSet = new int[26];
        for (char ch : str.toCharArray()) {
            chSet[ch - 'a']++;
        }
        return Arrays.toString(chSet);
    }
}