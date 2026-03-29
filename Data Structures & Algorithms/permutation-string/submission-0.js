class Solution {
  /**
   * @param {string} s1
   * @param {string} s2
   * @return {boolean}
   */
  checkInclusion(s1, s2) {
    if (s1.length > s2.length) return false;

    const s1Count = {},
      windowCount = {};

    for (let i = 0; i < s1.length; i++) {
      s1Count[s1.charAt(i)] = (s1Count[s1.charAt(i)] || 0) + 1;
      windowCount[s2.charAt(i)] = (windowCount[s2.charAt(i)] || 0) + 1;
    }

    if(this.matches(s1Count,windowCount)) return true;

    let l = 0;

    for(let r = s1.length; r < s2.length;r++){
      windowCount[s2.charAt(r)] = (windowCount[s2.charAt(r)] || 0) + 1;

      windowCount[s2.charAt(l)]--;
      if(windowCount[s2.charAt(l)] === 0){
        delete windowCount[s2.charAt(l)];
      }
      l++;

      if(this.matches(s1Count,windowCount)) return true;
    }

    return false;

  }
  matches(obj1,obj2){
    const keys1 = Object.keys(obj1);
    const keys2 = Object.keys(obj2);

    if(keys2.length !== keys1.length) return false;

    for(const key of keys1){
      if(obj1[key] !== obj2[key]) return false;
    }

    return true;
  }
}