enum Color{
    RED(0),
    WHITE(1),
    BLUE(2);
    final int color;
    Color(int color){
        this.color = color;
    }
}

class Solution {
    static void main() {
        int[] nums = new int[]{1,0,1,2};
        Solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int r = 0,w = 0, b = 0;
        for (int num : nums) {
            if (num == Color.RED.color) {
                r++;
            } else if (num == Color.BLUE.color) {
                b++;
            } else if (num == Color.WHITE.color) {
                w++;
            }
        }
        int i = 0;
        while (r-- >0) nums[i++] = Color.RED.color;
        while (w-- >0) nums[i++] = Color.WHITE.color;;
        while (b-- >0) nums[i++] = Color.BLUE.color;
    }
}