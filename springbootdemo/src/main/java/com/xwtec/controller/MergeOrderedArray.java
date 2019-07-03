package com.xwtec.controller;

import java.util.Arrays;

/**
 * merge 合并  orderedArray    有序数组
 */
public class MergeOrderedArray {
    public static int[] merge(int [] a,int []b){
        //入参校验  是否有序

        if(!isOrderedArray(a)){
            System.out.println(" array a is not an ordered array.");
            return null;
        }

        if(!isOrderedArray(b)){
            System.out.println(" array b is not an ordered array.");
            return null;
        }
//获取2个数组的长度
        int a_len = a.length;
        int b_len = b.length;
        //创建一个合并的新数组   长度为2个数组的长度和
        int[] merge = new int[a_len+b_len];
        int i=0,j=0,k=0;
        while(i<a_len&&j<b_len){
            if(a[i]<b[j]){
                merge[k++]=a[i++];
            }else{
                merge[k++]=b[j++];
            }
        }

        //A数组全部合并完毕，将b数组剩余直接加入合并数组
        if(i==a_len){
            for(;j<b_len;j++){
                merge[k++]= b[j];
            }
        }else{
            for(;i<a_len;i++){
                merge[k++]= a[i];
            }
        }

        return merge;

    }

    public static boolean isOrderedArray(int [] array){
        if(array==null||array.length==0){
            return false;
        }

        for(int i = 0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a [] = {1,2,3,4,5};
        int b [] = {2,3,4,5,6,7,8,9};
        int [] merge = merge(a,b);
        System.out.println(Arrays.toString(merge));
    }
}