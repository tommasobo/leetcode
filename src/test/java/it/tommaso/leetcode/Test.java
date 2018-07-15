package it.tommaso.leetcode;


import static org.junit.Assert.*;

/**
 * Created by Tommaso Bonato on 15/07/2018.
 * Class to test my leetcode problems
 */
public class Test {

    // FirstNonRepeatingChar
    @org.junit.Test
    public void testFirstNonRepeatingChar() {
        FirstNonRepeatingChar classInstance = new FirstNonRepeatingChar();

        /*
         * Testing 3 scenarios:
         * - Empty String
         * - Normal String with repeating chars
         * - String with only unique chars
         * - String with only repeating chars
         */
        assertEquals(-1, classInstance.simpleSolution(""));
        assertEquals(6, classInstance.simpleSolution("mammamia"));
        assertEquals(0, classInstance.simpleSolution("ciao"));
        assertEquals(-1, classInstance.simpleSolution("aabbccddeeffghhiillmmg"));
    }

}
