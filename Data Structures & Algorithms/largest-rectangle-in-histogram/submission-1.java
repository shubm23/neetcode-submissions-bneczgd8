class Solution {
    public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i <= heights.length; i++) {
                int currentHeight = i == heights.length ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                    int top = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, width * heights[top]);
                }
                stack.push(i);
            }
            return max;
        }
}
