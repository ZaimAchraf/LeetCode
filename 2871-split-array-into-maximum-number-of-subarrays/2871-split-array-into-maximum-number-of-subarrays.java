class Solution {
    public int maxSubarrays(int[] nums) {
        int bitwise = nums[0];
        int count = 1;

        // if(nums.length == 1) return 1;

        for (int i = 1; i < nums.length; i++) {
            bitwise = bitwise & nums[i];
        }

        // System.out.println(bitwise);

        if (bitwise != 0)
            return 1;

        bitwise = nums[0];
        
        for (int i = 1; i < nums.length + 1; i++) {

            if (i == nums.length) {
                if (bitwise != 0) {
                    count--;
                }
                break;
            }
            
            if (bitwise != 0) {
                bitwise = bitwise & nums[i];
                continue;
            }

            bitwise = nums[i];
            count++;


        }

        return count;
    }
}






