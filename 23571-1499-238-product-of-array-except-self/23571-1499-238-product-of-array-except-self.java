class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, nbrZeros = 0;
        int[] answer = new int[nums.length];

        for (int num:nums) {
            if (num == 0) {
                nbrZeros++;
                continue;
            }

            product *= num;
        }

        if (nbrZeros > 1) return answer;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                answer[i] = product;
                continue;
            }
            answer[i] = nbrZeros > 0 ? 0 : product/nums[i];
        }

        return answer;
    }
}