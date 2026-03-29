class Solution {
  /**
   * @param {string} s
   * @return {string}
   */
  longestPalindrome(s) {
    let maxLen = 0,
      start = 0;
    for (let i = 0; i < s.length; i++) {
      const len1 = this.expandFromCenter(s, i, i); // Odd-length palindromes
      const len2 = this.expandFromCenter(s, i, i + 1); // Even-length palindromes
      const len = Math.max(len1, len2);
      if (maxLen < len) {
        maxLen = len;
               start = i - Math.floor((len - 1) / 2);

      }
    }

    return s.substring(start, start + maxLen);
  }

  expandFromCenter(s, i, j) {
    while (i >= 0 && j < s.length && s.charAt(i) === s.charAt(j)) {
      i--;
      j++;
    }
    return j - i - 1;
  }
}