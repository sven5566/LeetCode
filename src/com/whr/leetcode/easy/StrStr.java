package com.whr.leetcode.easy;

/**
 * 题目：
 Implement strStr().
 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 翻译：
 实现一个方法strStr()。返回字符串needle第一次在字符串haystack出现的下标，如果needle不是haystack的一部分，就返回-1。

 分析：
 在文本中查找某个模式出现的位置的算法，称为字符串匹配算法。常用的方法有朴素字符串匹配算法、KMP算法等。
 朴素字符串匹配算法，就是把2个字符串头部对齐，然后逐一字符匹配，失配后，把needle右移一位，继续从头匹配。我们这里采用KMP算法。
 */
public class StrStr {

	public static void main(String[] args) {

	}

	/**
	 * 改进的Next指针算法
	 *
	 * @param s
	 * @return
	 */
	private static int[] getNext(String s) {
		int[] next = new int[s.length()];
		next[0] = 0;
		if (s.length() == 1) {
			return next;
		}
		next[1] = 0;
		int i = 1;
		int j = 0;
		while (i < s.length() - 1) {
			if (s.charAt(i) == s.charAt(j)) {
				j++;
				i++;
				if (s.charAt(i) == s.charAt(j)) {
					next[i] = next[j - 1];
				} else {
					next[i] = j;
				}
			} else {
				if (j == 0) {
					i++;
					next[i] = 0;
				} else {
					j = next[j];
				}
			}
		}
		return next;
	}
	/**
	 * KMP字符串匹配算法
	 * @return
	 */
	private static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int[] next = getNext(needle);
		int index = -1;
		int i = 0;
		int j = 0;
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == needle.length() - 1) {
					return i - j;
				}
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = next[j];
				}
			}
		}
		return index;
	}
}
