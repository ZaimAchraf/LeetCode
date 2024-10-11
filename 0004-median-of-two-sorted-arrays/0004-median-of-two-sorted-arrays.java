class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0, index = 0;

        int [] merged = new int[nums1.length + nums2.length];

        while (i != nums1.length && j != nums2.length) {
            // System.out.println("hey");
            if ( nums1[i] >= nums2[j] ) {
                merged[index] = nums2[j];
                j++;
            }else {
                merged[index] = nums1[i];
                i++;
            }
            index ++;
        }

        int size = (nums1.length + nums2.length);
        double median = 0;
        System.out.println(j + " " + i);
        if (i == nums1.length) {
            System.out.println(j + " " + i);
            if (size % 2 == 0) {
                if (index != 0 && index == (size/2)) {
                    median = (double) (merged[index - 1] + nums2[j])/2;
                } else if (index > (size/2)) {
                    median = (double) (merged[size/2 - 1] + merged[size/2])/2;
                }else {
                    median = (double) (nums2[size/2 - i - 1] + nums2[size/2 - i])/2;
                }
            }else {
                if (index != 0 && index > (size/2)) {
                    median = merged[size/2];
                }else {
                    median = nums2[(size/2) - i];
                }
            }
        }else{
            if (size % 2 == 0) {
                if (index != 0 && index == (size/2)) {
                    System.out.println(merged[size/2 - 1] + " " + nums1[i]);
                    median = (double) (merged[index - 1] + nums1[i])/2;
                } else if (index > (size/2)) {
                    System.out.println(merged[size/2 - 1] + " " + merged[size/2 + 1]);
                    median = (double) (merged[size/2 - 1] + merged[size/2])/2;
                }else {
                    median = (double) (nums1[size/2 - 1 - j] + nums1[size/2 - j])/2;
                }
            }else {
                if (index != 0 && index > (size/2)) {
                    median = merged[size/2];
                }else {
                    System.out.println(size/2 - j);
                    median = nums1[size/2 - j];
                }
            }
        }
        
        return median;
    }

}