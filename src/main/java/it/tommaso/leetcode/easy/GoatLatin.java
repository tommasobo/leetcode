package it.tommaso.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tommaso Bonato
 *
 * A sentence S is given, composed of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are available here: https://leetcode.com/problems/goat-latin/description/
 *
 */
class GoatLatin {

    private List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    /**
     * Using a StringBuilder to build the new string. Also using a second stringbuilder to count how
     * many words we have encountered and add the equivalent amount of 'a'.
     * Space complexity: O(n) more technically O(n + k^2) -> New string. K is the number of words
     * Time complexity: O(n), more technically O(n + k^2) -> K is the number of words
     *
     * @param S String to convert
     * @return converted String
     */
    String toGoat(String S) {
        if (S.length() == 0) {
            return S;
        }

        StringBuilder appendAfterWord = new StringBuilder("a");
        StringBuilder sBuilder = new StringBuilder();

        for (String word : S.split(" ")) {
            if (appendAfterWord.length() > 1) {
                sBuilder.append(" ");
            }

            if (vowels.contains(word.charAt(0))) {
                sBuilder.append(word);
            } else {
                sBuilder.append(word.substring(1));
                sBuilder.append(word.charAt(0));
            }

            sBuilder.append("ma");
            sBuilder.append(appendAfterWord.toString());
            appendAfterWord.append("a");
        }

        return sBuilder.toString();

    }
}
