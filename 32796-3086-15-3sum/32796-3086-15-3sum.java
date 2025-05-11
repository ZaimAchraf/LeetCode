class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int j, k, sum;
        List<Integer> arr;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            j = i + 1;
            k = nums.length - 1;
            
            while (j < k) {
                if (i == j) {
                    j++;
                    continue;
                }

                if (i == k) {
                    k--;
                    continue;
                }

                sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                }else if (sum < 0) {
                    j++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < nums.length - 1 && nums[j] == nums[j+1]) j++;
                    while (k > 0 && nums[k] == nums[k-1]) k--;

                    j++;
                    k--;
                }
            
            }
        }

        return result;
    }
}