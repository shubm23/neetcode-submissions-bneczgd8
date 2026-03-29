class Solution {
    /**
     * @param {number[][]} intervals
     * @return {number}
     */
    eraseOverlapIntervals(intervals) {
      if (intervals.length === 0) return 0;
      intervals.sort((a,b)=>a[1] - b[1]);
      let remove = 0 , prevEnd = intervals[0][1];
      for(let i = 1;i < intervals.length;i++){
        if(intervals[i][0] < prevEnd){
          remove++;
        }else{
          prevEnd = intervals[i][1];
        }
      }

      return remove;
    }
}
