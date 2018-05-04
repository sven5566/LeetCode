package com.whr.leetcode.medium;

import java.util.*;

/**
 * 题目链接：https://leetcode.com/problems/top-k-frequent-elements/

 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm’s time complexity must be better than O(n log n), where n is the array’s size.

 思路：

 定义一个类 保存一个num的值和频率，并实现比较方法

 遍历数组，并用hashMap保存各个数字出现的频率
 对hashmap的value集合排序，获取频率最高的k位

 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer,FEntity> map = new HashMap<Integer,FEntity>();
		//统计各数字出现的次数 存入hashmap
		for(int t:nums){
			FEntity f;
			if(map.containsKey(t)){
				f = map.get(t);
				f.frequent++;
			}else{
				f = new FEntity(t, 1);
			}
			map.put(t, f);
		}
		//对hashmap的value 按照频率进行排序
		List<FEntity> values = new ArrayList<FEntity>();
		Set<Integer> keys = map.keySet();
		for(Integer key:keys){
			values.add(map.get(key));
		}
		Collections.sort(values);
		//统计频率最高的k个数
		for(int i=0;i<k;i++){
			res.add(values.get(values.size()-1-i).num);
		}
		return res;
	}
	class FEntity implements Comparable<FEntity> {
		int num, frequent;

		public FEntity(int num, int frequent) {
			this.num = num;
			this.frequent = frequent;
		}

		public int compareTo(FEntity arg0) {
			if (frequent > arg0.frequent)
				return 1;
			else if (frequent == arg0.frequent)
				return 0;
			else
				return -1;
		}
	}
}
