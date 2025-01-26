class Solution {
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1, left = 0, count = 0, temp;

        while (right >= left) {

            if (right == left && nums[right] != val) {
                count++;
                break;
            }

            if (nums[right] == val) {
                right--;
                continue;
            }

            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                right--;
            }
            left++;
            count++;
        }

        

        return count;
    }
}