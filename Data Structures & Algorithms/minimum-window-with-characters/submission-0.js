class Solution {
  /**
   * @param {string} s
   * @param {string} t
   * @return {string}
   */
  minWindow(s, t) {
    const window = {},
      countT = {};

    for (const c of t.split('')) {
      countT[c] = 1 + (countT[c] || 0);
    }

    let have = 0,
      need = Object.keys(countT).length;
    let res = [-1, -1],
      resLen = Number.MAX_VALUE;
    let l = 0;

    for (let r = 0; r < s.length; r++) {
      window[s.charAt(r)] = 1 + (window[s.charAt(r)] || 0);
      if (
        s.charAt(r) in countT &&
        countT[s.charAt(r)] === window[s.charAt(r)]
      ) {
        have++;
      }

      while (have === need) {
        if (r - l + 1 < resLen) {
          resLen = r - l + 1;
          res = [l, r];
        }
        window[s.charAt(l)] -= 1;
        if (
          s.charAt(l) in countT &&
          window[s.charAt(l)] < countT[s.charAt(l)]
        ) {
          have--;
        }
        l++;
      }
    }

    return resLen === Number.MAX_VALUE ? '' : s.substring(res[0], res[1] + 1);
  }
}