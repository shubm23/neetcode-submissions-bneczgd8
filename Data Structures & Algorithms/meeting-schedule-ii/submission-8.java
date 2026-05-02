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
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Interval interval : intervals) {
            if (!queue.isEmpty() && queue.peek().end <= interval.start) {
                queue.poll();
            }
            queue.offer(interval);
        }
        return queue.size();
    }
}
