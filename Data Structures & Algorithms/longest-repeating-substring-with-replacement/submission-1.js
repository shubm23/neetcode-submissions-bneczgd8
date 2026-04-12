class Solution {
    /**
     * @param {string} s
     * @param {number} k
     * @return {number}
     */
    characterReplacement(s, k) {
        let l = 0, longestSub = 0;
        const count = {};
        
        for (let r = 0; r < s.length; r++) {
            // Add current character to window
            count[s.charAt(r)] = (count[s.charAt(r)] || 0) + 1;
            
            // Shrink window if invalid
            // Invalid: windowSize - maxFreq > k
            let maxVal = Object.values(count).sort((a,b)=>b-a);
            
            while (r - l + 1 - maxVal[0] > k) {
                count[s.charAt(l++)]--;
            }
            
            // Update max length
            longestSub = Math.max(longestSub, r - l + 1);
        }
        
        return longestSub;
    }
}