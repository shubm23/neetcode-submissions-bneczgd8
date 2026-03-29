class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s) {
        let l = 0, longSubs = 0;
        const window = new Set();
        for(let r = 0;r < s.length;r++){
            while(window.has(s.charAt(r))){
                const ch = s.charAt(l++);
                window.delete(ch);
            }
            window.add(s.charAt(r));
            longSubs = Math.max(longSubs, r - l + 1);
        }
        return longSubs;
    }
}