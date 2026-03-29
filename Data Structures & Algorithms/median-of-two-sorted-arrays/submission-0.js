class Solution {
  /**
   * @param {number[]} nums1
   * @param {number[]} nums2
   * @return {number}
   */
  findMedianSortedArrays(nums1, nums2) {
    let A = nums1,
      B = nums2,
      total = nums1.length + nums2.length,
      half = Math.floor(total / 2);

    if (B.length < A.length) {
      [A, B] = [B, A]; // Proper swap using destructuring
    }
    
    let l = 0,
      r = A.length - 1;
      
    while (true) {
      let mid = Math.floor((l + r) / 2);
      let j = half - mid - 2; // Adjust index calculation

      let aleft = mid >= 0 ? A[mid] : -Infinity;
      let aright = mid + 1 < A.length ? A[mid + 1] : Infinity;
      let bleft = j >= 0 ? B[j] : -Infinity;
      let bright = j + 1 < B.length ? B[j + 1] : Infinity;

      if (aleft <= bright && bleft <= aright) {
        if (total % 2 != 0) {
          return Math.min(aright, bright);
        }
        return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2;
      } else if (aleft > bright) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
  }
}