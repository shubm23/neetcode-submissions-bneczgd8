class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];

        for (char ch : tasks) {
            counts[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : counts) {
            if (cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.add(new int[]{cnt, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
