package com.whr.leetcode.sort;

/**
 * http://blog.jobbole.com/113863/
 */
class SortFactory {
    static void doSort(int [] arr,Class<? extends Sort> argrithm) throws IllegalAccessException, InstantiationException {
        Sort sortArgrithm = argrithm.newInstance();
        sortArgrithm.sort(arr);
    }
}
