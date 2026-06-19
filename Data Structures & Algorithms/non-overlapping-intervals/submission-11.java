class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = intervals[0][1];
        int nonOverlapping = 0;
        for (int[] interval : Arrays.copyOfRange(intervals, 1, intervals.length)) {
            if (interval[0] < prevEnd) {
                nonOverlapping++;
            } else {
                prevEnd = interval[1];
            }
        }
        return nonOverlapping;
    }
}
