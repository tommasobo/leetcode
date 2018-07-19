package it.tommaso.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tommaso Bonato
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 */
class JewelsAndStones {

    private static int DIFFERENCE = 'z' - 'a' + 1;

    /**
     * Set to store the jewels and then check with a for.
     * Space complexity: O(n) -> Numbers of jewels. Worst case scenario for the set
     * Time complexity: O(n+m) -> We run two for once.
     *
     * @param J stones that are jewels
     * @param S my stones
     * @return number of jewels I own
     */
    int myJewels(String J, String S) {

        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }

        int myJewels = 0;
        Set<Character> listJewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            listJewels.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (listJewels.contains(S.charAt(i))) {
                myJewels++;
            }
        }
        return myJewels;
    }

    /**
     * Array of fixed size to store the jewels and then check with a for. Elegant solution using a small
     * array
     * Space complexity: O(1) -> As long as we assume a certain set of chars.
     * Time complexity: O(n+m) -> We run two for once.
     *
     * @param J stones that are jewels
     * @param S my stones
     * @return number of jewels I own
     */
    int myJewelsNoSpace(String J, String S) {

        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }

        int myJewels = 0;
        byte[] jewels = new byte[DIFFERENCE*2]; // upper and lower case letters of the english alphabet

        for (int i = 0; i < J.length(); i++) {
            if (Character.isLowerCase(J.charAt(i))) {
                jewels[J.charAt(i) - 'a']++;
            } else {
                jewels[(J.charAt(i) - 'A' + 1) + DIFFERENCE-1]++;
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLowerCase(S.charAt(i)) && (jewels[S.charAt(i) - 'a'] == 1)) {
                myJewels++;
            } else if (Character.isUpperCase(S.charAt(i)) && (jewels[(S.charAt(i) - 'A' + 1 ) + DIFFERENCE-1] == 1)) {
                myJewels++;
            }
        }

        return myJewels;
    }

    /**
     * Array of fixed size to store the jewels and then check with a for. Fast solution using all ascii
     * numbers and not checking if alphabetic
     * Space complexity: O(1) -> As long as we assume a certain set of chars.
     * Time complexity: O(n+m) -> We run two for once.
     *
     * @param J stones that are jewels
     * @param S my stones
     * @return number of jewels I own
     */
    int myJewelsFast(String J, String S) {

        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }

        int myJewels = 0;
        byte[] jewels = new byte[256]; // All ascii chars

        for (int i = 0; i < J.length(); i++) {
            jewels[J.charAt(i)]++; // We can assume no overflow here since there are at most 50 chars
        }

        for (int i = 0; i < S.length(); i++) {
            if (jewels[S.charAt(i)] >= 1) {
                myJewels++;
            }
        }
        return myJewels;
    }
}
