class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int findKthLargest(int[] nums, int k) {
        try {
            for (int num : nums) {
                maxHeap.offer(num);
            }
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    return maxHeap.poll();
                }
                maxHeap.poll();
            }
            return -1;
        } catch (NullPointerException e) {
            return -1;
        }
    }
}