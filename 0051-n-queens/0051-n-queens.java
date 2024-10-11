class Solution {

    private List<int[]> intResult = new ArrayList<>();
    private List<List<String>> stringResult = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[] solution = new int[n];
        boolean[] exist = new boolean[n];
        
        rec(0, solution, n, exist);

        intResult.forEach(res -> {
            List<String> strings = new ArrayList<>();
            for (int index : res) {
                // System.out.println(Arrays.toString(res));
                StringBuilder st = new StringBuilder(".".repeat(n));
                st.setCharAt(index, 'Q');
                strings.add(st.toString());
            }
            stringResult.add(strings);
        });
        return stringResult;
    }

    private void rec(int line, int[] solution, int n, boolean[] present) {

        if (line == n) {
            // System.out.println("result = " + Arrays.toString(solution));
            intResult.add(Arrays.copyOf(solution, solution.length));
            return;
        }
        
        int[] sol = Arrays.copyOf(solution, solution.length);
        boolean[] exist = Arrays.copyOf(present, present.length);

        int br;

        for (int i = 0 ; i < n; i++) 
        {
            if (exist[i]) continue;

            br = 0;

            if (line != 0) {
                
                for (int j = 0; j<line; j++) {
                    if (Math.abs(solution[j] - i) == line - j) {
                        br = 1;
                        break;
                    }
                }

                if (br == 1) continue;
            }

            // System.out.println("sol = " + Arrays.toString(sol));
            // System.out.println(Arrays.toString(exist));
            // System.out.println("line = " + line);

            sol[line] = i;
            exist[i] = true;

            rec(line+1, sol, n, exist);

            sol[line] = 0;
            exist[i] = false;
        }

    }
}