class Solution {
    /**
     * @param {number[]} temperatures
     * @return {number[]}
     */
    dailyTemperatures(temperatures) {
        const res = new Array(temperatures.length).fill(0) , stack = [];

        for(let i = 0;i < temperatures.length;i++){
            while(stack.length && temperatures[stack[stack.length - 1]] < temperatures[i]){
                const popIdx = stack.pop();
                res[popIdx] = i - popIdx;
            }
            stack.push(i);
        }

        return res;
    }
}
