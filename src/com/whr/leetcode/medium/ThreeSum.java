package com.whr.leetcode.medium;

import java.util.*;

/**
 * Leet Code OJ 15. 3Sum[Difficulty: Medium]
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},
 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 翻译：
 给定一个数组S，它包含n个整数，它是否存在3个元素a，b，c，满足a+b+c=0?找出所有满足条件的元素数组。
 提示：a，b，c三个元素必须是升序排列（也就是满足a ≤ b ≤ c），最终的结果不能包含重复的元素数组。
 例如给定S为{-1 0 1 2 -1 -4}，返回结果是(-1, 0, 1)和(-1, -1, 2)。

 分析：
 最容易想到的方法就是3重循环遍历所有可能的元素，进行判断是否等于0。下面的方案作了一些改进：
 1. 对数组进行排序，跳过肯定会大于0的结果
 2. 借助map避免第三层遍历
 3. 由于做了排序，所以可以较为容易的跳过重复的结果
 */
public class ThreeSum {
	public static void main(String[] args) {
		final List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(lists);
	}
	private static List <List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		//nums先进行排序
		Arrays.sort(nums);
		Map<Integer, List<Integer>> map = new HashMap<>();
		//分类
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.get(num) == null) {
				List<Integer> subscripts = new ArrayList<>();
				subscripts.add(i);
				map.put(num, subscripts);
			} else {
				map.get(num).add(i);
			}
		}
		for (int i = 0; i <= nums.length - 3; i++) {
			//从小到大排列，大于0的就不用再看
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int finalNum = -nums[i] - nums[j];
				if (finalNum < nums[j]) {
					break;
				}
				List<Integer> subscripts = map.get(finalNum);
				if (subscripts == null) {
					continue;
				}
				for (Integer subscript : subscripts) {
					if (subscript != j && subscript != i) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[subscript]);
						res.add(list);
						break;
					}
				}
			}
		}
		return res;
	}
}
