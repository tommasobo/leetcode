package it.tommaso.leetcode;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Tommaso Bonato on 15/07/2018.
 * Class to test my leetcode problems
 */
public class Test {

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

    @org.junit.Test
    public void testToLowerCase() {
        ToLowerCase classInstance = new ToLowerCase();

        assertEquals("ciao", classInstance.toLowerCase("ciao"));
        assertEquals("ciao", classInstance.toLowerCase("CIAO"));
        assertEquals("ciao", classInstance.toLowerCase("CiAo"));
        assertEquals("", classInstance.toLowerCase(""));
        assertEquals("5345", classInstance.toLowerCase("5345"));
        assertEquals("-.è", classInstance.toLowerCase("-.è"));
        assertEquals(null, classInstance.toLowerCase(null));

    }

    @org.junit.Test
    public void testMorseCode() {
        MorseCodeWords morseCode = new MorseCodeWords();

        assertEquals(2, morseCode.getTransformations(new String[]{"gin", "zen", "gig", "msg"}));
        assertEquals(2, morseCode.getTransformations(new String[]{"a", "a", "a", "b"}));
        assertEquals(0, morseCode.getTransformations(new String[]{"", "", "", ""}));
        assertEquals(0, morseCode.getTransformations(new String[]{}));

        assertEquals(2, morseCode.getTransformationsComplex(new String[]{"gin", "zen", "gig", "msg"}));
        assertEquals(2, morseCode.getTransformationsComplex(new String[]{"a", "a", "a", "b"}));
    }

    @org.junit.Test
    public void testRobotMoves() {
        JudgeRouteCircle routeRobot = new JudgeRouteCircle();

        assertEquals(true, routeRobot.backToOrigin("LLLLRRRR"));
        assertEquals(true, routeRobot.backToOrigin("LRUDDULR"));
        assertEquals(true, routeRobot.backToOrigin(""));
        assertEquals(false, routeRobot.backToOrigin("LLR"));
        assertEquals(false, routeRobot.backToOrigin("LRUDLRUU"));
        assertEquals(false, routeRobot.backToOrigin("LL"));

        assertEquals(true, routeRobot.backToOriginSimple("LLLLRRRR"));
        assertEquals(true, routeRobot.backToOriginSimple("LRUDDULR"));
        assertEquals(true, routeRobot.backToOriginSimple(""));
        assertEquals(false, routeRobot.backToOriginSimple("LLR"));
        assertEquals(false, routeRobot.backToOriginSimple("LRUDLRUU"));
        assertEquals(false, routeRobot.backToOriginSimple("LL"));
    }

    @org.junit.Test
    public void testFlipImage() {
        FlipImage flipImage = new FlipImage();

        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0},{0,1,0},{1,1,1}}, flipImage.flipSimple(new int[][]{{1,1,0},{1,0,1},{0,0,0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0},{0,1,0},{1,1,1}}, flipImage.flipOnePass(new int[][]{{1,1,0},{1,0,1},{0,0,0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0},{0,1,0},{1,1,1}}, flipImage.flipOnePassAdvanced(new int[][]{{1,1,0},{1,0,1},{0,0,0}})));

        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0,1},{1,0,1,0},{1,1,1,1}}, flipImage.flipSimple(new int[][]{{0,1,1,0},{1,0,1,0},{0,0,0,0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0,1},{1,0,1,0},{1,1,1,1}}, flipImage.flipSimple(new int[][]{{0,1,1,0},{1,0,1,0},{0,0,0,0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1,0,0,1},{1,0,1,0},{1,1,1,1}}, flipImage.flipSimple(new int[][]{{0,1,1,0},{1,0,1,0},{0,0,0,0}})));

        assertTrue(Arrays.deepEquals(new int[][]{{1}}, flipImage.flipSimple(new int[][]{{0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1}}, flipImage.flipOnePass(new int[][]{{0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{1}}, flipImage.flipOnePassAdvanced(new int[][]{{0}})));

        assertTrue(Arrays.deepEquals(new int[0][0], flipImage.flipSimple(new int[0][0])));
        assertTrue(Arrays.deepEquals(new int[0][0], flipImage.flipOnePass(new int[0][0])));
        assertTrue(Arrays.deepEquals(new int[0][0], flipImage.flipOnePassAdvanced(new int[0][0])));
    }

    @org.junit.Test
    public void testToeplitz() {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

        assertFalse(toeplitzMatrix.isToeplitz(new int[][]{{1,2},{2,2}}));
        assertTrue(toeplitzMatrix.isToeplitz(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
    }
}
