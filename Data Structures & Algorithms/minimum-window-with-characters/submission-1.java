class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int[] res = {-1, -1};
        int l = 0, have = 0, resLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            countT.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        int need = countT.size();

        for (int i = 0; i < s.length(); i++) {
            window.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);

            if (countT.containsKey(s.charAt(i)) && countT.get(s.charAt(i)).equals(window.get(s.charAt(i)))) {
                have++;
            }

            while (have == need) {
                if (i - l + 1 < resLen) {
                    resLen = i - l + 1;
                    res = new int[]{l, i};
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);

                if (countT.containsKey(s.charAt(l)) && countT.get(s.charAt(l)) > window.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
