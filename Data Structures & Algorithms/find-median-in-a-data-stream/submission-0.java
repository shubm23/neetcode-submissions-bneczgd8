class MedianFinder {
    private final PriorityQueue<Integer> lo;
    private final PriorityQueue<Integer> hi;

    public MedianFinder() {
        //max heap
        lo = new PriorityQueue<>(Collections.reverseOrder());
        //min heap
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);
        hi.add(lo.poll());
        if (lo.size() < hi.size()) {
            lo.offer(hi.poll());
        }
    }

    public double findMedian() throws NullPointerException {
        if (lo.size() > hi.size()) return lo.peek();
        return (lo.peek() + hi.peek()) / 2.0;
    }
}