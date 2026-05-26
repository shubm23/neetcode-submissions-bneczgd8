class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int c = 0;
        int[][] intervalCpy = new int[intervals.length+1][2];
        for(int[] interval : intervals){
            intervalCpy[c] = interval;
            c++;
        }
        intervalCpy[c] = newInterval;
        Arrays.sort(intervalCpy,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        
        for(int i = 0;i < intervalCpy.length;i++){
            if(res.isEmpty() || res.getLast()[1] < intervalCpy[i][0]){
                res.add(intervalCpy[i]);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1],intervalCpy[i][1]);
            }
        }
        
        return res.toArray(new int[res.size()][]);
        
    }
}
