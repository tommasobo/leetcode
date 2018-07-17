package it.tommaso.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tommaso Bonato
 *
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
 * We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 *
 */
class MorseCodeWords {

    private String[] morseAlphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                                      "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * Simple implementation using a Set to store the morse code words and a StringBuilder to generate them
     * Space complexity: O(n) -> Set if all different words
     * Time complexity: O(n) -> iterate each word once
     *
     * @param words List of words to convert to morse code
     * @return number of unique morse code "words"
     */
    int getTransformations(String[] words) {

        Set<String>  setWords = new HashSet<>();

        for (String word : words) {
            StringBuilder newMorse = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (Character.isAlphabetic(c)) {  // Should be useless, but still a safety check
                    newMorse.append(morseAlphabet[c - 'a']);
                }
            }
            if (!newMorse.toString().isEmpty()) { //If the string is empty, we shouldn't add it
                setWords.add(newMorse.toString());
            }
        }

        return setWords.size();
    }

    /**
     * Java 8 solution of the code above basically
     * Space complexity: O(n) -> Set if all different words
     * Time complexity: O(n) -> iterate each word once
     *
     * @param words List of words to convert to morse code
     * @return number of unique morse code "words"
     */
    int getTransformationsComplex(String[] words) {
        Set<String> res = Arrays.stream(words).map(this::getMC).collect(Collectors.toSet());
        return res.size();
    }

    private String getMC(String str) {
        return str.chars().mapToObj(ch -> morseAlphabet[(char)ch - 'a']).reduce("", String::concat);
    }
}
