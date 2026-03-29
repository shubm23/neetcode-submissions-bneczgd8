class Solution {
  /**
   * @param {string[]} tokens
   * @return {number}
   */
  evalRPN(tokens) {
    const stack = [];
    tokens.forEach((token) => {
      if (token === '+') {
        const first = Number(stack.pop());
        const second = Number(stack.pop());
        stack.push(first + second);
      } else if (token === '-') {
        const first = Number(stack.pop());
        const second = Number(stack.pop());
        stack.push(second - first);
      } else if (token === '*') {
        const first = Number(stack.pop());
        const second = Number(stack.pop());
        stack.push(first * second);
      } else if (token === '/') {
        const first = Number(stack.pop());
        const second = Number(stack.pop());
        stack.push(Math.trunc(second / first));
      } else {
        stack.push(token);
      }
    });
    return stack[0];
  }
}
