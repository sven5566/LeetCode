package com.whr.leetcode.medium;

/**
 *  题目链接：https://leetcode.com/problems/bulb-switcher/
 题目：

 There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
 On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round,
 you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.

 思路：

 本题实际是求N以内平方数个数问题，设有一数k < = n，若k有x个约数，则遍历的过程中必然对k操作x次。
 第k个灯泡一开始是on的，若x为偶数，最后依然是on的，若x为奇数，最后一定是off的。

 问题就变成求约数是偶数的灯泡的个数。对于数N，若该数有约数B，则N/B也必定为该数的约数。
 当B==N/B时，N的约数为奇数个，N=B*B，即N为完全平方数。 问题转化成求N以内完全平方数的个数。
 在1<=k<=n中，只有第1^2、2^2、3^2、4^2……m^2<=n个灯泡为on，m也就是要求的为on的灯泡总数，
 m<=n的平方根，即对N开方向下取整。java对double类型向int转化正好是向下取整。
 */
public class BulbSwitcher {
}
