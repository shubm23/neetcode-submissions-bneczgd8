class Solution {
  /**
   * @param {string} s
   * @param {number} k
   * @return {number}
   */
  characterReplacement(s, k) {
    let l = 0,
      longestSub = 0;
    const count = {};
    for (let r = 0; r < s.length; r++) {
      count[s.charAt(r)] = (count[s.charAt(r)] || 0) + 1;
      while (r - l + 1 - Math.max(...Object.values(count)) > k) {
        count[s.charAt(l++)]--;
      }
      longestSub = Math.max(longestSub, r - l + 1);
    }

    return longestSub;
  }
}