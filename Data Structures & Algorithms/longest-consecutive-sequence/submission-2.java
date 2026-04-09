class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        
        int longConsecutiveLen = 0;
        for(int num : nums){
            if(numSet.contains(num + 1)){
                continue;
            }
            int currentLen = 1;
            int curr = num;
            while(numSet.contains(curr - 1)){
                currentLen++;
                curr--;
            }
            longConsecutiveLen = Math.max(longConsecutiveLen,currentLen);
        }
        
        return longConsecutiveLen;
    }
}
