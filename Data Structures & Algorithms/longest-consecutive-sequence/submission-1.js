class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    longestConsecutive(nums) {
      const numsSet = new Set([...nums]);
      let longConsec = 0;
      for(const num of nums){
        if(numsSet.has(num + 1)){
          continue;
        }
        let counter = 1;
        let curr = num;
        while(numsSet.has(--curr)){
          counter++;
        }
        longConsec = Math.max(longConsec,counter);
      }
      return longConsec;
    }
}
