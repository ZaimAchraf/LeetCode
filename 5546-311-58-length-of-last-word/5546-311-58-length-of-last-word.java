class Solution {
    
    public int lengthOfLastWord(String s) {
        int i, j = s.length() - 1;
        while (s.charAt(j) == ' ') {
            j--;
        }
        for (i = j; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
        }

        return j - i;
    }
}