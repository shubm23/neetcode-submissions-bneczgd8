class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (Character tCh : t.toCharArray()) {
            tMap.merge(tCh, 1, Integer::sum);
        }

        int have = tMap.size(), need = 0, longestWindow = Integer.MAX_VALUE, l = 0;
        int[] range = new int[2];

        for (int r = 0; r < s.length(); r++) {
            Character rightCh = s.charAt(r);
            sMap.merge(rightCh, 1, Integer::sum);
            if (tMap.containsKey(rightCh) && tMap.get(rightCh).equals(sMap.get(rightCh)))
                need++;

            while (need == have) {
                Character leftCh = s.charAt(l);
                int currWindowLen = r - l + 1;
                if (currWindowLen < longestWindow) {
                    longestWindow = currWindowLen;
                    range[0] = l;
                    range[1] = r;
                }

                sMap.put(leftCh, sMap.get(leftCh) - 1);
                if (tMap.containsKey(leftCh) && tMap.get(leftCh) > sMap.get(leftCh))
                    need--;
                l++;
            }
        }

        return longestWindow == Integer.MAX_VALUE ? "" : s.substring(range[0], range[1] + 1);
    }
}
