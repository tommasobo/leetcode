package it.tommaso.leetcode;

/**
 * @author Tommaso Bonato
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
class ToeplitzMatrix {

    /**
     * Simple implementation using two for loops and checking each element one by one
     * Space complexity: O(1) -> No additional structures required
     * Time complexity: O(n*m) -> we iterate the matrix
     *
     * @param matrix matrix to study
     * @return whether the matrix is Toeplitz or not
     */
    boolean isToeplitz(int[][] matrix) {

        for (int i =  0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i+1 < matrix.length) && (j+1 < matrix[i+1].length)) {
                    if (!(matrix[i][j] == matrix[i + 1][j + 1])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
