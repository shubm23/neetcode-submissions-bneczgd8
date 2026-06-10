class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int findKthLargest(int[] nums, int k) {
        try {
            for (int num : nums) {
                minHeap.offer(num);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            }
            return minHeap.poll();
        } catch (NullPointerException e) {
            return -1;
        }
    }
}