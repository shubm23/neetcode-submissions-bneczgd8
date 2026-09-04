class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    int longSub = 0;
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      char rChar = s.charAt(r);
      while (seen.contains(rChar)) {
        seen.remove(s.charAt(l++));
      }
      seen.add(rChar);
      longSub = Math.max(longSub, r - l + 1);
    }
    return longSub;
  }
}
