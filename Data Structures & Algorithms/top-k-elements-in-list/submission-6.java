class Solution {
    // TC -> O(NlogK) , SC -> O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            seen.merge(num, 1, Integer::sum);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> entry : seen.entrySet()) {
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (minHeap.isEmpty())
                break;
            res[i] = minHeap.poll()[0];
        }

        return res;
    }
}
