class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s) {
         const formattedStr = this.removeNonAplhaNumericChars(s).split("").map(el => el.toLowerCase());
    let i = 0, j = formattedStr.length - 1;
    while(i < j){
      if(formattedStr[i] !== formattedStr[j]) return false;
      i++;
      j--;
    }
    return true;
    }

    removeNonAplhaNumericChars(s){
  return s.replace(/[^A-Za-z0-9]/g, '');
}
}
