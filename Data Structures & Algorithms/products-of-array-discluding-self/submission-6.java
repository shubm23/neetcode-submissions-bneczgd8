class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];

        Arrays.fill(product, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            product[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] *= suffix;
            suffix *= nums[i];
        }

        return product;
    }
}
