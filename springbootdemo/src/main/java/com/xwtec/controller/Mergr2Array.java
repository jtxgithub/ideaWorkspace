package com.xwtec.controller;

import java.util.Arrays;

/**
 * 合并2个有序数组
 * 创建一个新的数组用于存放所有的数组元素，将2个数组的元素
 * 循环比较，剩下的直接放入数组就ok
 */
public class Mergr2Array {

    public static int[] getNewArray(int[] a, int[] b) {
        //入参检验    是否有序数组
        if (!isOrderedArray(a)) {
            System.out.print("数组a不是有序数组");
            return null;
        }
        if (!isOrderedArray(b)) {
            System.out.print("数组a不是有序数组");
            return null;
        }

        int aLen = a.length;
        int bLen = b.length;
        int[] c = new int[aLen + bLen];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aLen && j < bLen) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        //如果有一个数组合并完了，剩余的直接放到末尾
        if (i == aLen) {
            //还剩b数组
            for (; j < bLen; j++) {
                c[k++] = b[j];
            }
        } else {
            //还剩b数组
            for (; i < aLen; i++) {
                c[k++] = a[i];
            }
        }


        return c;
    }


    public static boolean isOrderedArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 12, 30};
        int[] b = {3, 4, 6, 10, 12, 16};
        int[] c = getNewArray(a, b);
        System.out.print(Arrays.toString(c));

    }

}
