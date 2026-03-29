class MedianFinder {
    //min Heap
    PriorityQueue<Integer> hi;
    //max Heap
    PriorityQueue<Integer> lo;
    
    public MedianFinder() {
        this.hi = new PriorityQueue<>();
        this.lo = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if(hi.size() > lo.size()){
            lo.offer(hi.poll());
        }
        
    }
    
    public double findMedian() {
        if(hi.size() < lo.size()) return lo.peek();
        return (lo.peek() + hi.peek()) / 2.0;
    }
}
