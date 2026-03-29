/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {number}
     */
    minMeetingRooms(intervals) {
       let rooms = 0, endPointers = 0;
      const startIntervals = intervals.map(interval=>interval.start).sort((a,b)=>a-b);
      const endIntervals = intervals.map(interval=>interval.end).sort((a,b)=>a-b);

      for (let i = 0; i < startIntervals.length; i++) {
        if(startIntervals[i] < endIntervals[endPointers]){
          rooms++;
        }else{
          endPointers++;
        }
      }

      return rooms;
    }
}
