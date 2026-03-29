class Solution {
  /**
   * @param {number[]} heights
   * @return {number}
   */
  maxArea(heights) {
    let i = 0,
      j = heights.length - 1,
      max = 0;
    while (i < j) {
      if (heights[i] > heights[j]) {
        max = Math.max(max, (heights[j]) * (j - i));
        j--;
      } else {
        max = Math.max(max, (heights[i]) * (j - i));
        i++;
      }
    }
    return max;
  }
}