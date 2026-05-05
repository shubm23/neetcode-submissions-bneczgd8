class Solution {
   public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]) {
                int idx = stack.removeLast();
                result[idx] = i - idx;
            }
            stack.add(i);
        }

        return result;
    }
}
