class KthLargest {
    private final PriorityQueue<Integer> heap;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        try {
            this.heap.offer(val);
            if(this.heap.size() > k){
                this.heap.poll();
            }
            return this.heap.peek();
        }catch (Exception e){
            return -1;
        }
    }
}