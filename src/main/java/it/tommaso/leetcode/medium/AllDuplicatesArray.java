package it.tommaso.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommaso Bonato
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others
 * appear once.
 *
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 */
class AllDuplicatesArray {

    /**
     * When we encounter an element the first time, we set array[currentLocation] - 1 as negative.
     * If that location is already negative, it means we have already seen the number, hence we add it to
     * the duplicates list. Basically we implement a sort of hashmap in place.
     *
     * Initial array is altered but could go back to the initial using abs() on each element.
     *
     * Space complexity: O(1) -> No additional structures required
     * Time complexity: O(n) -> iterating the array
     *
     * @param nums array
     * @return list of duplicated
     */
    List<Integer> getDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index - 1] = -nums[index - 1];
            }
        }

        return duplicates;
    }
}
