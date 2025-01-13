class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(dfs(board, word, visited, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int r, int c, int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(index) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        boolean found = dfs(board, word, visited, r + 1, c, index + 1) ||
                        dfs(board, word, visited, r - 1, c, index + 1) ||
                        dfs(board, word, visited, r, c + 1, index + 1) ||
                        dfs(board, word, visited, r, c - 1, index + 1);

        visited[r][c] = false;

        return found;
    }
}