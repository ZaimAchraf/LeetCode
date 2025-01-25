// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Set<Integer> hashSet = new HashSet<>();
//         Collections.addAll(hashSet, Arrays.stream(nums).boxed().toArray(Integer[]::new)); 
//         int i = 1;
//         while (true) {
//             if (!hashSet.contains(i)) return i;
//             i++;
//         }
//     }
// }

class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length, temp, i;
        for (i = 0; i < n; i++) {

            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (i = 0; i<n; i++) {
            if (nums[i] != (i + 1)) 
                return i + 1;
        }

        return n + 1;
    }
}