package it.tommaso.leetcode;

/**
 * @author Tommaso Bonato
 *
 * Implement function ToLowerCase() that has a string parameter str,
 * and returns the same string in lowercase.
 */
class ToLowerCase {

    private static int DIFFERENCE = 'A' - 'a';

    /**
     * Very simple implementation using ascii numbers of the chars.
     * Better to use a StringBuilder instead since otherwise we would create a new String each time
     * making the code much slower and potentially O(n^2)
     * Space complexity: O(n) -> Support Array
     * Time complexity: O(n) -> Just iterate the array once.
     *
     * @param string Word to analyze
     * @return lower case string
     */
    String toLowerCase(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }

        StringBuilder builder = new StringBuilder(string);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) <= 'Z' && string.charAt(i) >= 'A') {
                builder.setCharAt(i, (char)(string.charAt(i) - DIFFERENCE));
            }
        }
        return builder.toString();
    }
}
