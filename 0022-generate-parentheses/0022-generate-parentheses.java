class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        rec ("(", 1, 0, n);
        return result;
    }

    private void rec(String str, int i, int j, int n) {
        // System.out.println(new StringBuilder(str));

        if (i == n) {
            StringBuilder match = new StringBuilder(str);
            for (int k=j;k<n;k++) {
                match.append(")");
            }
            result.add(match.toString());
            return;
        }
        
        if (i == j){
            rec(new StringBuilder(str).append("(").toString(), i+1, j, n);
            return;
        }

        rec(new StringBuilder(str).append("(").toString(), i+1, j, n);
        rec(new StringBuilder(str).append(")").toString(), i, j+1, n);
    }
}