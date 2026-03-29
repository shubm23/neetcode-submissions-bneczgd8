class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
       return strs.map(el => el.length + "#" + el).join("");
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
       const result = [];
       let i = 0;
       while(i < str.length){
           let j = i;
           while(str[j] !== "#"){
               j++;
           }
           const len = parseInt(str.substring(i,j));
           const start = j + 1;
           const end = start + len;
           result.push(str.substring(start,end));
           i = end;
       }
       return result;
    }
}