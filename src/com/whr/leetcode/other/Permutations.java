package com.whr.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permutations {
    private static String [] arrays={"A","B","C","D"};
    public static void main(String[] args) {
        List<String>result=new ArrayList<>();
        perm(arrays,0,result);
        System.out.println(result);
        System.out.println(result.size());
    }

    private static void swap(String [] arr,int from,int to){
        final String tmp=arr[from];
        arr[from]=arr[to];
        arr[to]=tmp;
    }

    private static void perm(String[]arr,int start,List<String>result){
        if(start>=arr.length){
            StringBuilder sb=new StringBuilder();
            for (String anArr : arr) {
                sb.append(anArr);
            }
            result.add(sb.toString());
        }else{
            for(int i=start;i<arr.length;++i){
                swap(arr,start,i);
                perm(arr,start+1,result);
                swap(arr,i,start);
            }
        }
    }
}
