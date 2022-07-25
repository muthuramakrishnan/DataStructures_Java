//This doesn't compile
//Driver code has to be inserted

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        boolean isUp = true;
        int row = 0, col = 0, i = 0;

        while (row < m && col < n) {
            if (isUp) {
                while (row > 0 && col < n - 1) {
                    result[i++] = mat[row][col];
                    row--;
                    col++;
                }
                result[i++] = mat[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (col > 0 && row < m - 1) {
                    result[i++] = mat[row][col];
                    row++;
                    col--;
                }
                result[i++] = mat[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            isUp = !isUp;
        }
        return result;
    }
}