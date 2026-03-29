class Solution {
    /**
     * @param {number[]} candidates
     * @param {number} target
     * @return {number[][]}
     */
    combinationSum2(candidates, target) {
      const res = [];
      candidates.sort((a,b)=>a-b);

      function backTrack(idx,currentPath,currentSum){
          if(currentSum === target){
            res.push([...currentPath]);
            return;
          }

          if(currentSum > target) return;

          for(let i = idx;i < candidates.length;i++){
            if(i > idx && candidates[i-1] === candidates[i]) continue;
            currentPath.push(candidates[i]);
            backTrack(i+1,currentPath,currentSum+candidates[i]);
            currentPath.pop();
          }
      }

      backTrack(0,[],0);

      return res;
    }
}