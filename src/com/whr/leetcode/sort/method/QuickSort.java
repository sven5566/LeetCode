package com.whr.leetcode.sort.method;

import com.whr.leetcode.sort.Sort;
import com.whr.leetcode.sort.Util;

import java.util.Arrays;

/**
 * http://blog.jobbole.com/113863/
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] sort) {
        quickSort(sort,0,sort.length-1);
    }

    void quickSort(int A[], int left, int right)
    {
        if (left >= right)
            return;
        int pivot_index = partition(A, left, right); // 基准的索引
        System.out.println("基准="+pivot_index);
        System.out.println("数组="+Arrays.toString(A));
        quickSort(A, left, pivot_index - 1);
        quickSort(A, pivot_index + 1, right);
    }
    int partition(int A[], int left, int right)  // 划分函数
    {
        int pivot = A[right];               // 这里每次都选择最后一个元素作为基准
        int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++)  // 遍历基准以外的其他元素
        {
            if (A[i] <= pivot)              // 把小于等于基准的元素放到前一个子数组末尾
            {
                Util.swap(A, ++tail, i);
            }
        }
        Util.swap(A, tail + 1, right);           // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
        // 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
        return tail + 1;                    // 返回基准的索引
    }
}
