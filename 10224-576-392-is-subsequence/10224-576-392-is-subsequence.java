class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        if (s.length() == 0) return true;

        if (s.length() > t.length()) return false;

        while (i < t.length()) {
            
            if (s.charAt(j) == t.charAt(i)) j++;

            if (j == s.length()) return true;

            i++;
        }

        return false;
    }
}