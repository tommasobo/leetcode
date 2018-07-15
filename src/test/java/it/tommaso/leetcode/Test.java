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
         * Testing 4 scenarios:
         * - Empty String
         * - Normal String with repeating chars
         * - String with only unique chars
         * - String with only repeating chars
         * - Long random stream with unique chars
         */
        assertEquals(-1, classInstance.slowSolution(""));
        assertEquals(6, classInstance.slowSolution("mammamia"));
        assertEquals(0, classInstance.slowSolution("ciao"));
        assertEquals(-1, classInstance.slowSolution("aabbccddeeffghhiillmmg"));

        assertEquals(-1, classInstance.solutionWithSupportArray(""));
        assertEquals(6, classInstance.solutionWithSupportArray("mammamia"));
        assertEquals(0, classInstance.solutionWithSupportArray("ciao"));
        assertEquals(-1, classInstance.solutionWithSupportArray("aabbccddeeffghhiillmmg"));

        assertEquals(-1, classInstance.hashMapSolution(""));
        assertEquals(6, classInstance.hashMapSolution("mammamia"));
        assertEquals(0, classInstance.hashMapSolution("ciao"));
        assertEquals(-1, classInstance.hashMapSolution("aabbccddeeffghhiillmmg"));

        assertEquals(-1, classInstance.linkedHashMapSolution(""));
        assertEquals(6, classInstance.linkedHashMapSolution("mammamia"));
        assertEquals(0, classInstance.linkedHashMapSolution("ciao"));
        assertEquals(-1, classInstance.linkedHashMapSolution("aabbccddeeffghhiillmmg"));

    }

}
