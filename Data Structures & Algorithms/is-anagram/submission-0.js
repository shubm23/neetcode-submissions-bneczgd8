class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        const sArr = s.split("").sort().join('');
        const tArr = t.split("").sort().join('');
        return sArr === tArr;
    }
}
