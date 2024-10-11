class Solution {
    
    String s, p;
    int[][] dp ;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;

        this.dp = new int[s.length()][p.length()];

        return rec (0,0);
    }

    private boolean rec (int i, int j) {


        if (i == s.length() && j == (p.length() - 1))
            return p.charAt(j) == '*';
        
        if (i == s.length() && j == p.length())
            return true;

        // System.out.println(j + " : " + p.length());
        if (i == s.length() ) {
            if ((p.charAt(j + 1) == '*') || (p.charAt(j) == '*')) {
                return rec(i, j + 1) ;
            }
            
        }

        if (i == s.length()  || j == p.length() ) {
            return false;
        }

        if (dp[i][j] != 0) return dp[i][j] == 1;

        if (p.charAt(j) == '*') {
            if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
                dp[i][j] = rec(i, j + 1) ? 1 : -1;
                return dp[i][j] == 1;
            }  

            dp[i][j] = (rec(i, j + 1) || rec(i + 1, j)) ? 1 : -1;
            return dp[i][j] == 1;
        }

        if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {

            if (j < (p.length() - 1) && p.charAt(j + 1) == '*') {
                dp[i][j] = (rec(i + 1, j + 1) || rec(i, j + 1)) ? 1 : -1;
                return dp[i][j] == 1;
            }

            dp[i][j] = rec(i + 1, j + 1) ? 1 : -1;
            return dp[i][j] == 1;

        }else if (j < (p.length() - 1) && p.charAt(j + 1) == '*') {

            dp[i][j] = rec(i, j + 1) ? 1 : -1;
            return dp[i][j] == 1;
        }

        dp[i][j] = -1;

        return false;

    }
}