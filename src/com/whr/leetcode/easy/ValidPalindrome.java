package com.whr.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 For example,
 “A man, a plan, a canal: Panama” is a palindrome.
 “race a car” is not a palindrome.
 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 For the purpose of this problem, we define empty string as valid palindrome.

 翻译：
 给定一个字符串，检测它是否是回文对称的，只考虑其中字母与数字的字符。
 例如”A man, a plan, a canal: Panama”是回文对称的，”race a car”不是。
 提示：你考虑过字符串可能是空的情况吗？这是一个面试中应该问出的好问题。为了处理这个问题，我们假定空串是回文对称的。

 分析：
 直接遍历比较是很困难的，我们需要先进行过滤（大写转小写）。过滤后只要将前后对应位置的字符直接比较就可以了。过程中要注意有的时候会涉及char和int的强转。
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println("result="+isPalindrome("asdfdsa"));
	}

	/**
	 * 大小写转换
	 * @return
	 */
	private static boolean isPalindrome(String s){
		char[] charArr=s.toCharArray();
		List<Integer> list=new ArrayList<>();
		int fix='a'-'A';
		for(char c:charArr){
			if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
				list.add((int)c);
			}else if(c>='A'&&c<='Z'){
				list.add(c+fix);
			}
		}
		int size=list.size();
		for(int i=0;i<size/2;i++){
			if(list.get(i)!=list.get(size-1-i)){
				return false;
			}
		}
		return true;
	}
}
