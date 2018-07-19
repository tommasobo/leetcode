package it.tommaso.leetcode.easy;

/**
 * @author Tommaso Bonato
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 */
class FlipImage {

    /**
     * Simple implementation using two for, one for each operation
     * Space complexity: O(1) -> No additional structures required (just a constant temp int)
     * Time complexity: O(n*m) -> we iterate the matrix
     *
     * @param A matrix to flip
     * @return flipped Matrix
     */
    int[][] flipSimple(int[][] A) {
        for (int[] row : A) {
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length-1-i];
                row[row.length-i-1] = temp;
            }
        }

        for (int[] row : A) {
            for (int i = 0; i < row.length; i++) {
                row[i] = row[i] == 1 ?  0 :  1;
            }
        }
        return A;
    }

    /**
     * Simple implementation using a single for and an if to flip each element.
     * Space complexity: O(1) -> No additional structures required (just a constant temp int)
     * Time complexity: O(n*m) -> we iterate the matrix
     *
     * @param A matrix to flip
     * @return flipped Matrix
     */
    int[][] flipOnePass(int[][] A) {
        for (int[] row : A) {
            if (row.length % 2 != 0) {
                row[row.length / 2] = row[row.length / 2] == 1 ?  0 :  1;
            }
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length-1-i];
                row[i] = row[i] == 1 ?  0 :  1;
                row[row.length-i-1] = temp;
                row[row.length-i-1] = row[row.length-i-1] == 1 ?  0 :  1;
            }
        }
        return A;
    }

    /**
     * Simple implementation using a single for and bit operations to flip each element
     * Space complexity: O(1) -> No additional structures required (just a constant temp int)
     * Time complexity: O(n*m) -> we iterate the matrix
     *
     * @param A matrix to flip
     * @return flipped Matrix
     */
    int[][] flipOnePassAdvanced(int[][] A) {
        for (int[] row : A) {
            if (row.length % 2 != 0) {
                row[row.length / 2] = row[row.length / 2]^1;
            }
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length-1-i]^1;
                row[row.length-i-1] = temp^1;
            }
        }
        return A;
    }

}


