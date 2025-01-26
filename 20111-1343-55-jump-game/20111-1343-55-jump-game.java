class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, j = 0, nbrZeros = 0;
        int[] zeros = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                zeros[j] = i;
                j++;
            }
        }

        nbrZeros = j;
        j--;

        if (nbrZeros == 0) return true;

        for (int i = zeros[nbrZeros - 1]; i >= 0; i--) {
           

            // if (i == zeros[j]) return false;

            if (nums[i] >= zeros[j] - i + 1) {
                while (zeros[j] > i) {
                    j--;
                    if (j < 0) return true;
                }
                i = zeros[j];
                continue;
            }
        }

        return false;
    }
}