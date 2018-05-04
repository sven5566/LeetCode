package com.whr.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.（不要使用额外的空间）
 * Some hints:
 * <p>
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 * <p>
 * <p>
 * <p>
 * 分析：
 * <p>
 * 回文数，并且题目要求不能使用额外的空间。
 * <p>
 * <p>
 * <p>
 * 即，不能使用回文串的方法。
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println("result=" + isPalindrome2(12342321));
	}

	/**
	 * 倒置数解法，可能引起溢出
	 *
	 * @param x
	 * @return
	 */
	private static boolean isPalindrome(int x) {
		int a = 0;
		int b = x;
		while (b > 0) {
			a = a * 10 + b % 10;
			b /= 10;
		}
		return a == x;
	}

	/**
	 * 取首尾两个数字
	 *
	 * @param x
	 * @return
	 */
	private static boolean isPalindrome2(int x) {
		if(x<0){
			return false;
		}
		int len=1;
		while(x/len>=10){
			len*=10;
		}
		while(x>0){
			int left=x/len;
			int right=x%10;
			if(left!=right){
				return false;
			}else {
				x=(x%len)/10;
				len/=100;
			}
		}
		return true;
	}
}
