class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        let l = 0 , r = height.length - 1;
        let lmax = height[l], rmax = height[r];
        let res = 0;
        while(l < r){
            if(lmax <= rmax){
                l++;
                lmax = Math.max(lmax,height[l]);
                res += lmax - height[l];
            }else{
                r--;
                rmax = Math.max(rmax,height[r]);
                res += rmax - height[r];
            }
        }
        return res;
    }
}
