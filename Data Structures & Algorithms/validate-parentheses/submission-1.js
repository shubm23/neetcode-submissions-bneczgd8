class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s) {
      const stack = [];
      const obj = {
        ")":"(",
        "]":"[",
        "}":"{"
      }
      for(const bracket of s.split("")){
        if(Object.hasOwn(obj,bracket)){
          if (stack.pop() !== obj[bracket]) return false;
        }else{
          stack.push(bracket);
        }
      }

      return stack.length === 0;
    }
}
