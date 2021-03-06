package it.tommaso.leetcode.medium;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * @author Tommaso Bonato
 */
public class Test {

    @org.junit.Test
    public void testDuplicatesArray() {
        AllDuplicatesArray allDuplicatesArray = new AllDuplicatesArray();

        int[] answer = allDuplicatesArray.getDuplicates(new int[]{1,2,4,5,2,1,6}).stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        assertTrue(Arrays.equals(new int[]{1,2}, answer));
        answer = allDuplicatesArray.getDuplicates(new int[]{1,2,4,3}).stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        assertTrue(Arrays.equals(new int[]{}, answer));
        answer = allDuplicatesArray.getDuplicates(new int[]{1,1,1,1,2,1,2}).stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        assertTrue(Arrays.equals(new int[]{1,1,1,1,2}, answer));

    }

    @org.junit.Test
    public void testSkyline() {
        MaxIncreaseSkyline maxIncreaseSkyline = new MaxIncreaseSkyline();
    }
}
