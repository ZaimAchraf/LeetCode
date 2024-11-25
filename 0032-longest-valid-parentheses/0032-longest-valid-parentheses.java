class Solution {
    public int longestValidParentheses(String s) {
        
        int[] dp = new int[s.length()];
        int max = 0;
        
        if (s.length() == 0) return 0;
        
        for (int i = 1; i<s.length(); i++) 
        {
            if (s.charAt(i) == '(') 
                continue;
            
            // here we know s[i] == ')'
            
            if (s.charAt(i - 1) == '(')
            { 
                
                dp[i] = 1 + ( i > 1 ? dp[i - 2] : 0);
                
                if (dp[max] < dp[i]) max = i;
                
                continue;
            }
            
            if (s.charAt(i - 1) == ')') 
            {
                
                if (dp[i - 1] == 0 || i <= (dp[i-1] * 2) ){
                    dp[i] = 0;
                    continue;
                }
                
                if (s.charAt(i - (dp[i-1] * 2) - 1) == '(') {
                    dp[i] = 1 + dp[i-1];
                    
                    if (i - (dp[i-1] * 2) - 2 >= 0) dp[i] += dp[i - (dp[i-1] * 2) - 2];
                    
                    if (dp[max] < dp[i]) max = i;
                }
            }
        }
        
        return dp[max]*2;
        
    }
}


// ")((()((())"
//  0123456789
// 