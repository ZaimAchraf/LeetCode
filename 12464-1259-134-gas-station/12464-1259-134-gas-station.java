class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int max = gas [n - 1] - cost[n- 1], maxIndex = n - 1;
        int sum = max;

        if (n == 1 && max < 0) return -1;

        for (int i = n - 2; i >= 0; i--) {
            
            sum += gas [i] - cost[i];

            if (i == 0 && sum < 0) return -1;

            if (sum > max) {
                max = sum;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}