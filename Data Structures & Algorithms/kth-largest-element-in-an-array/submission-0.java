class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Collections.reverseOrder());

        for(int num : nums){
            queue.offer(num);
        }

        while (k-1 > 0){
            queue.poll();
            k--;
        }

        return queue.peek();
    }
}
