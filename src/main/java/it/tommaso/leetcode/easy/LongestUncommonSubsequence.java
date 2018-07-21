package it.tommaso.leetcode.easy;

/**
 * @author Tommaso Bonato
 *
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence
 * should not be any subsequence of the other strings.
 *
 * Personal note: This problem is stupid and worded stupidly.
 *
 */
 class LongestUncommonSubsequence {

    /**
     * Simple implementation checking if the string is equals otherwise returning the longest one
     * Space complexity: O(1) -> No additional structures required
     * Time complexity: O(n) -> Java length is O(1) + Java equals is O(n)
     *
     * @param a first string
     * @param b  second string
     * @return whether the matrix is Toeplitz or not
     */
    int lengthSubsequence(String a, String b) {

        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
