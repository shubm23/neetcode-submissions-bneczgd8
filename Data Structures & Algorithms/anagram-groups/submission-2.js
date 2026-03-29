class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */

    getFreqKey(str){
        const alphaArr = new Array(26).fill(0);
        for(const char of str.split('')){
            const alphaIdx = char.charCodeAt(0) - 'a'.charCodeAt(0);
            alphaArr[alphaIdx]++;
        }
        return alphaArr.join();
    }

    groupAnagrams(strs) {
        const seen = new Map();
        for(const str of strs){
            const key = this.getFreqKey(str);
            const seenSet = seen.get(key) || [];
            if(seen.has(key)){
                seenSet.push(str);
                seen.set(key,seenSet);
            }else{
                seenSet.push(str);
                seen.set(key,seenSet);
            }
        }
        return [...seen.values()];
    }
}
