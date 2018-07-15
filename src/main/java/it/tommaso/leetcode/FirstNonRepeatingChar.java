package it.tommaso.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    int slowSolution(String string) {

        boolean foundAnother;
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

    /**
     * Simple implementation using a support array. Works only with the 26 letters from the english alphabet or
     * a set of chars of max 26 different chars.
     * Space complexity: O(1) -> Only because we are using a fixed array
     * Time complexity: O(n)
     *
     * @param string Word to analyze
     * @return index of the first non repeating char. -1 if not present.
     */
    int solutionWithSupportArray(String string) {

        char[] countChar = new char[26];
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            countChar[string.charAt(i) - 'a']++;
        }
        for (int i = 0; i < string.length(); i++) {
            if (countChar[string.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Slightly more advanced implementation using a hashmap
     * Space complexity: O(n)
     * Time complexity: O(n)
     *
     * @param string Word to analyze
     * @return index of the first non repeating char. -1 if not present.
     */
    int hashMapSolution(String string) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (map.get(string.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Advanced implementation using a LinkedHashMap and Java8
     * Space complexity: O(n)
     * Time complexity: O(n)
     *
     * @param string Word to analyze
     * @return index of the first non repeating char. -1 if not present.
     */
    int linkedHashMapSolution(String string) {

        Map<Character, Long> collect =  string.chars().mapToObj(i -> (char)i).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Optional<Character> firstUnique = collect.entrySet().stream().
                filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst();

        for (int i = 0; i < string.length(); i++) {
            if (firstUnique.isPresent() && (string.charAt(i) == firstUnique.get())) {
                return i;
            }
        }
        return -1;
    }
}
