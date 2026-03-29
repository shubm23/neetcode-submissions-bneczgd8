class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 1. Map the characters we need from t
        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int need = countT.size();
        int have = 0;
        int l = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};
        char[] sChars = s.toCharArray();

        for (int r = 0; r < sChars.length; r++) {
            char c = sChars[r];
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 2. If current char is in T and frequency matches, we satisfied a character requirement
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // 3. Try to shrink the window from the left while it's valid
            while (have == need) {
                // Update result if this window is smaller than the previous smallest
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = sChars[l];
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing the left char makes the window invalid
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}