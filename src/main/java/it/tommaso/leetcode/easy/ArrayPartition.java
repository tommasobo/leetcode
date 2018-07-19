package it.tommaso.leetcode.easy;

import java.util.Arrays;

/**
 * @author Tommaso Bonato
 *
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 */
class ArrayPartition {

    /**
     * Best way is to sort the array and take the smallest number of each group and sum it.
     * Space complexity: O(log(N)) -> No additional data structures but space for quicksort
     * Time complexity: O(n * log(n)) -> sort array
     *
     * @param nums array
     * @return biggest sum of the min(a,b) groups
     */
    int arrayPairSum(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * Store number in another array
     * Space complexity: O(1) -> Well technically O(1) because the array size is constant, but it
     * depends on the restrictions of the input
     * Time complexity: O(n) -> For
     *
     * @param nums array
     * @return biggest sum of the min(a,b) groups
     */
    int arrayPairSumNoSort(int[] nums) {
        int[] exist = new int[20000+1];
        for (int num : nums) {
            exist[num + 10000]++;
        }
        int sum = 0;
        boolean toSum = true;
        for (int i = 0; i < exist.length; i++) {
            while (exist[i] > 0) {
                if (toSum) {
                    sum += i - 10000;
                }
                toSum = !toSum;
                exist[i]--;
            }
        }
        return sum;
    }
}
