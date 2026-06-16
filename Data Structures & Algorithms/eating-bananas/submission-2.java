class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int l = 1, r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            if (canFinish(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean canFinish(int[] piles, int h, int mid) {
        int hrs = 0;
        for (int pile : piles) {
            hrs += (pile + mid - 1) / mid;
            if (hrs > h)
                return false;
        }
        return hrs <= h;
    }
}