class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1, sum = 0;
        int[] result = new int[2];

        while (i != j) {
            sum = numbers[i] + numbers[j];

            if (sum < target) {
                i++;
                continue;
            }

            if (sum > target) {
                j--;
                continue;
            }

            result[0] = i+1;
            result[1] = j+1;
            break;
        }

        return result;
    }
}