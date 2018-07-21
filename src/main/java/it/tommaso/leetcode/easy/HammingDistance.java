package it.tommaso.leetcode.easy;

/**
 * @author Tommaso Bonato
 *
 * Calculate the hamming distance between 2 ints. (it is the number of different bits)
 */
class HammingDistance {

    /**
     *
     * Space O(1) - Time O(1) considering the number of bytes is constant in an int or O(N+M) where N and M are the number of bytes
     */
    int distance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    int distanceWithoutDefault(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            count += (xor >>> i) & 1;
        }
        return count;
    }
}
