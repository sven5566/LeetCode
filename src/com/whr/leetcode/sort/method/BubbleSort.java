package com.whr.leetcode.sort.method;

import com.whr.leetcode.sort.Sort;

import static com.whr.leetcode.sort.Util.swap;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    swap(arr,j+1,j);
                }
            }
        }
    }
}
