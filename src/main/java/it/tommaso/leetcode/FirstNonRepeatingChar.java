package it.tommaso.leetcode;

/**
 * Created by Tommaso Bonato on 15/07/2018.
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 */

class FirstNonRepeatingChar {

    /**
     * Very simple implementation iterating the array for each element.
     * Space complexity: O(n)
     * Time complexity: O(n^2)
     *
     * @param string Word to analyze
     * @return index of the first non repeating char. -1 if not present.
     */
    int simpleSolution(String string) {

        boolean foundAnother = false;
        char[] charArray = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            foundAnother = false;
            for (int j = 0; j < string.length(); j++) {
                if ((charArray[i] == charArray[j]) && (i!=j)) {
                    foundAnother = true;
                }
            }

            if (!foundAnother) {
                return i;
            }
        }

        return -1;

    }
}
