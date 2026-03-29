class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int need = countT.size(), have = 0, l = 0, resLen = Integer.MAX_VALUE;
        int[] res = new int[]{0, 0};
        char[] sChars = s.toCharArray();
        for (int r = 0; r < sChars.length; r++) {
            char rightChar = s.charAt(r);
            window.compute(rightChar, (k, v) -> v == null ? 1 : v + 1);

            if (countT.containsKey(rightChar) && countT.get(rightChar).equals(window.get(rightChar))) {
                have++;
            }

            while (have == need) {
                if (r + 1 - l < resLen) {
                    resLen = r + 1 - l;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);

                window.put(leftChar, window.get(leftChar) - 1);

                if (countT.containsKey(leftChar) && countT.get(leftChar) > window.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}