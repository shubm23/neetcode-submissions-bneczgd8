class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());

        for(int stone : stones){
            queue.offer(stone);
        }

        while (queue.size() >1){
            int max1= queue.poll();
            int max2 = queue.poll();
            if(max1 != max2){
                queue.offer(max1 - max2);
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}