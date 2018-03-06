package com.whr.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

	private static int[] result;

	public static void main(String[] args) {
		result = solution(new int[]{1, 2, 3, 4}, 5);
		System.out.println(result[0]+"和"+result[1]);
	}

	private static int[] solution(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			final Integer index = map.get(target - nums[i]);
			if (index == null) {
				map.put(nums[i], i);
			} else {
				return new int[]{nums[index], nums[i]};
			}
		}
		return result;
	}
}
