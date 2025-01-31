class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candies = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || ratings[i] <= ratings[i - 1]) {
                candies[i] = 1;
            }else {
                candies[i] = candies[i - 1] + 1;
            }

            // System.out.println(candies[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || ratings[i] <= ratings[i + 1]) {
                count += candies[i];
                // continue;
            }else {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
                count += Math.max(candies[i + 1] + 1, candies[i]);
            }
            // System.out.println(candies[i]);
        }

        return count;
    }
}