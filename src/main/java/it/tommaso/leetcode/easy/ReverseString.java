package it.tommaso.leetcode.easy;

/**
 * @author Tommaso Bonato
 *
 * Reverse a string
 */
class ReverseString {

    /**
     * Very simple implementation swapping a char array in place. Can be done using a StringBuilder too
     * Space complexity: O(n) -> String are immutable in Java (yeah, you could do weird tricks).
     * Time complexity: O(n) -> Obviously need to iterate each element once
     *
     * @param s String to reverse
     * @return reversed String
     */
    String reverse(String s) {

        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length / 2; i++) {
            char temp = sArray[sArray.length - 1 - i];
            sArray[sArray.length - 1 - i] = sArray[i];
            sArray[i] = temp;
        }

        return String.valueOf(sArray);
    }
}
