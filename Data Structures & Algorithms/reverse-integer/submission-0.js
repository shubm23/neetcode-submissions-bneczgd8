class Solution {
  /**
   * @param {number} x
   * @return {number}
   */
  reverse(x) {
    const isNegative = x < 0;
    const reversed = parseInt(Math.abs(x).toString().split('').reverse().join(''));
    const result = isNegative ? -reversed : reversed;
    
    // Check if result is within 32-bit signed integer range
    if (result < -Math.pow(2, 31) || result > Math.pow(2, 31) - 1) {
      return 0;
    }
    
    return result;
  }
}