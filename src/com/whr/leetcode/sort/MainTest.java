package com.whr.leetcode.sort;

import com.whr.leetcode.sort.method.QuickSort;
import com.whr.leetcode.sort.method.QuickSort2;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        int[]arr=new int[]{9,3,6,12,2,7};
        System.out.println(Arrays.toString(arr));
        SortFactory.doSort(arr,QuickSort2.class);
        System.out.println(Arrays.toString(arr));
    }

}
