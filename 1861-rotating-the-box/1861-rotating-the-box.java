class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Apply gravity (stones fall right)
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // position where stone can fall
            
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j - 1; // reset after obstacle
                } 
                else if (boxGrid[i][j] == '#') {
                    char temp = boxGrid[i][empty];
                    boxGrid[i][empty] = '#';
                    if (empty != j) boxGrid[i][j] = '.';
                    empty--;
                }
            }
        }

        // Step 2: Rotate matrix
        char[][] res = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return res;
    }
}