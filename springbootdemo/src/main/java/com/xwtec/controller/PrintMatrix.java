package com.xwtec.controller;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * matrix 矩阵  printMatrix 打印矩阵 inCircle 内圆
 */
public class PrintMatrix {
    public void printMatrix(int[][] matrix) {
        //第一：入参校验 判断二维数组对象是否为空 或者数组不为空但是长度是否小于0

        if (matrix == null || matrix.length <= 0)
            return;
        //打印矩阵  二维数组
        printMatrixInCircle(matrix, 0);
    }

    //打印数字 传参：    数组、开始打印的横坐标
    private void printMatrixInCircle(int[][] matrix, int start) {
        //得到二维数组的行数     直接数组.length
        int row = matrix.length;
        //得到二维数组的列数    直接取第一个数组的长度
        int col = matrix[0].length;
        //计算每次打印的最后的行坐标   纵坐标    下标从0开始   所有都要减1
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        //如果最后的横纵坐标比开始坐标小   直接结束
        if (endX < start || endY < start)
            return;
        //仅一行   如果只有一行    直接循环一行就行
        if (endY == start) {
            for (int i = start; i <= endX; i++) {
                System.out.print(matrix[start][i] + " ");
            }
            return;  //记得结束
        }
        //仅一列
        if (endX == start) {
            for (int i = start; i <= endY; i++) {
                System.out.print(matrix[i][start] + " ");
            }
            return;  //记得结束
        }

        //打印边界
        //最上   从左往右
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i] + " ");
        }
        //最右   从上往下
        for (int i = start + 1; i <= endY; i++) {
            System.out.print(matrix[i][endX] + " ");
        }
        //最下   从右往左
        for (int i = endX - 1; i >= start; i--) {
            System.out.print(matrix[endY][i] + " ");
        }
        //最左   从下往上
        for (int i = endY - 1; i >= start + 1; i--) {
            System.out.print(matrix[i][start] + " ");
        }

        //继续打印更内部的矩阵，令start+1
        printMatrixInCircle(matrix, start + 1);
    }


    public static void main(String[] args) {
        PrintMatrix demo = new PrintMatrix();
       int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    // int[][] a= {};
//     int[][] a= {{}};
//      int[][] a= {{1}};
//      int[][] a= {{1,2,3,4}};
//      int[][] a= {{1},{2},{3},{4}};
//      int[][] a= {{1,2,3},{4,5,6}};
//      int[][] a=null;
        demo.printMatrix(a);
    }
}