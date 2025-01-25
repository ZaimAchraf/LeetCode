class Solution {
    String result;

    public String longestPalindrome(String s) {
        result = String.valueOf(s.charAt(0));

        for (int i = 0; i<s.length() - 1; i++) {

            if (i > 0 && s.charAt(i-1) == s.charAt(i+1)) {
                expandPalindrome(s, i-1, i+1);
            }

            if (s.charAt(i) == s.charAt(i + 1)) {
                expandPalindrome(s, i, i+1);
            }
        }

        return result;
    }

    public void expandPalindrome (String s, int i, int j) {
        while (true) {
            if (i == 0 || j == s.length() - 1) {
                break;
            }else if (s.charAt(i-1) == s.charAt(j+1)) {
                i--;
                j++;
            }else {
                break;
            }
        }

        // System.out.println("i : " + i + ", j : " + j + ", s : " + s);

        if (result == null || result.length() < (j - i + 1)) {
            result = s.substring(i, (j + 1));
        }
            
    }
}