class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreqMap = new HashMap<>();
        Map<Character, Integer> sFreqMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tFreqMap.merge(t.charAt(i), 1, Integer::sum);
        }
        int have = tFreqMap.size(), need = 0, l = 0;
        int minLen = Integer.MAX_VALUE;
        int[] range = new int[2];
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            sFreqMap.merge(rightChar, 1, Integer::sum);
            if (tFreqMap.containsKey(rightChar) && tFreqMap.get(rightChar).equals(sFreqMap.get(rightChar))) need++;
            while (need == have) {
                int windowLen = r - l + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    range[0] = l;
                    range[1] = r;
                }
                char leftChar = s.charAt(l);
                sFreqMap.put(leftChar, sFreqMap.get(leftChar) - 1);
                if (tFreqMap.containsKey(leftChar) && tFreqMap.get(leftChar) > sFreqMap.get(leftChar)) need--;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(range[0], range[1] + 1);
    }
}
