// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] result = new int[n + m];
//         int i=0, j=0;

//         for (int k = 0; k < n + m; k++) {

//             if (i < m && (j >= n || nums1[i] <= nums2[j])) {
//                 result[k] = nums1[i];
//                 i++;
//             }else {
//                 result[k] = nums2[j];
//                 j++;
//             }
//         }

//         for (int k = 0; k < n + m; k++) {
//             nums1[k] = result[k];
//         } 

//     }
// }

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1, j = n - 1;

        for (int k = n + m -1; k >= 0; k--) {

            if (j < 0) {
                break;
            }

            if ((i < 0) || nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
                continue;
            }else {
                nums1[k] = nums1[i];
                i--;
            }
        }

    }
}
