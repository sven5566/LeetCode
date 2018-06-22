package com.whr.leetcode.sort.method;

import com.whr.leetcode.sort.Sort;

/**
 * https://blog.csdn.net/yuxin6866/article/details/52771739
 */
public class QuickSort2 implements Sort {
    @Override
    public void sort(int[] sort) {
        quickSort(sort,0,sort.length-1);
    }
    void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = pivot;
            quickSort(array, left, low - 1);
            quickSort(array, low + 1, right);
        }
    }
}
