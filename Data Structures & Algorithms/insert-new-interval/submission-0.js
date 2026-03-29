class Solution {
    /**
     * @param {number[][]} intervals
     * @param {number[]} newInterval
     * @return {number[][]}
     */
    insert(intervals, newInterval) {
       intervals.push(newInterval);
       intervals.sort((a,b)=>a[0]-b[0]);
       const merge = [];

       for(const interval of intervals){
            if(merge.length === 0 || merge[merge.length - 1][1] < interval[0]){
                merge.push(interval);
            }else{
                merge[merge.length - 1][1] = Math.max( merge[merge.length - 1][1],interval[1]);
            }
       }

       return merge;
    }
}