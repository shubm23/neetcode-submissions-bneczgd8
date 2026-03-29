class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        Arrays.fill(res,0);

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]){
                int idx = stack.removeLast();
                res[idx] = i - idx;
            }
            stack.add(i);
        }

        return res;
    }
}
