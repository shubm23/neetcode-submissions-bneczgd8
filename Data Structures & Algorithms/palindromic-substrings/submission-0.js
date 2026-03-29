class Solution {
  /**
   * @param {string} s
   * @return {number}
   */
  countSubstrings(s) {
    let res = 0;
    for (let i = 0; i < s.length; i++) {
      res += this.expandFromCenter(s, i, i); // Odd-length palindromes
      res += this.expandFromCenter(s, i, i + 1); // Even-length palindromes
    }
    return res;
  }

  expandFromCenter(s, i, j, res) {
    let count = 0;
    while (i >= 0 && j < s.length && s.charAt(i) === s.charAt(j)) {
      i--;
      j++;
      count++;
    }
    return count;
  }
}
