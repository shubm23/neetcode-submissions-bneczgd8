class Solution {
  /**
   * @param {string} s1
   * @param {string} s2
   * @param {string} s3
   * @return {boolean}
   */
  isInterleave(s1, s2, s3) {
    if (s1.length + s2.length !== s3.length) return false;
    
    const memo = new Map();
    const dfs = (i1, i2) => {
      if (i1 === s1.length && i2 === s2.length) return true;
      
      const key = i1 + '-' + i2;
      if (memo.has(key)) return memo.get(key);
      
      let result = false;
      
      if (
        i1 < s1.length &&
        s1.charAt(i1) === s3.charAt(i1 + i2) &&
        dfs(i1 + 1, i2)
      ) {
        result = true;
      }
      else if (
        i2 < s2.length &&
        s2.charAt(i2) === s3.charAt(i1 + i2) &&
        dfs(i1, i2 + 1)
      ) {
        result = true;
      }
      
      memo.set(key, result);
      return result;
    };
    
    return dfs(0, 0);
  }
}