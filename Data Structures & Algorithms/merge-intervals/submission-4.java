class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<Interval> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.getLast().end < interval[0]) {
                res.add(new Interval(interval[0], interval[1]));
            } else {
                res.getLast().setEnd(Math.max(res.getLast().getEnd(), interval[1]));
            }
        }
        return res.stream().map(el -> new int[] {el.start, el.end}).toArray(int[][] ::new);
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}