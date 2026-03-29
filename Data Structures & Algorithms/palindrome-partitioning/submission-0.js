class Solution {
    /**
     * @param {string} s
     * @return {string[][]}
     */
    partition(s) {
         const res = [];
    function isPalindrome(s,i,j){
      while(i < j){
        if(s[i] !== s[j]) return false;
        i++;
        j--;
      }
      return true;
    }

    function dfs(i,part){
      if(i >= s.length){
        res.push([...part]);
        return;
      }

      for(let j = i;j < s.length;j++){
        if(isPalindrome(s,i,j)){
          part.push(s.slice(i,j+1));
          dfs(j+1,part);
          part.pop();
        }
      }
    }

    dfs(0,[]);

    return res;
    }
}
