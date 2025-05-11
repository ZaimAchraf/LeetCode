class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i =0, j = 0;
        int sum = nums[i], len = 1, minLen = nums.length + 1;

        while (j < nums.length) {

            if (sum >= target) {
                if (i == j) return 1;
                minLen = Math.min(minLen, len);
                sum -= nums[i];
                i++;
                len--;
            }else {
                j++;
                if (j < nums.length) sum += nums[j];
                len++;
            }

        }

        if (minLen == (nums.length + 1)) return 0;
        else return minLen;
    }
}