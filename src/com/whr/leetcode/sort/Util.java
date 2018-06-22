package com.whr.leetcode.sort;

public class Util {
    public static void swap(int[] arr, int i, int j){
        final int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
