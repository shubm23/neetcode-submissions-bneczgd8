/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public static int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!maxHeap.isEmpty() && maxHeap.peek() <= interval.start) {
                maxHeap.poll();
            }
            maxHeap.offer(interval.end);
        }
        return maxHeap.size();
    }
}
