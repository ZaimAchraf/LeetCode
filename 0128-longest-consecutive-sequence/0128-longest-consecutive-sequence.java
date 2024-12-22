class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int i = 0;
        int max = 0;
        
        for (int num:nums) {
            set.add(num);
        }
        
        
        for (Integer num:nums) {
            
            if (!set.contains(num - 1)){
                
                count = 1;
                i = num;
                
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }

                if (count > max) max = count;
            }
            
        }
        return max;
        
    }
}