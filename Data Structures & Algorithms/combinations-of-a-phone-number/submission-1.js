class Solution {
    /**
     * @param {string} digits
     * @return {string[]}
     */
    letterCombinations(digits) {
        const map = {
            "2":"abc",
            "3":"def",
            "4":"ghi",
            "5":"jkl",
            "6":"mno",
            "7":"pqrs",
            "8":"tuv",
            "9":"wxyz"
        }
        const res = [];
        let currStr = "";

        function backtrack(i,currStr){
            if(currStr.length === digits.length){
                res.push(currStr);
                return;
            }

            const charArr = map[digits[i]];

            for(const char of charArr){
                backtrack(i+1,currStr+char);
            }
        }

        digits.length > 0 && backtrack(0,currStr);

        return res;
    }
}
