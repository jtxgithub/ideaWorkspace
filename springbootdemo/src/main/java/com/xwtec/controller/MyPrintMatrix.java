package com.xwtec.controller;

/**
 * 打印矩阵
 * <p>
 * <p>
 * 二维数组   int[数组个数][每个数组的长度]
 */
public class MyPrintMatrix {

    //打印矩阵    入参：二维数组
    public void printByArray(int[][] array) {
//入参检验
        if (array == null || array.length <= 0) {
            System.out.print("数组为空");
            return;
        }

        print(array, 0);

    }

    private void print(int[][] array, int start) {
        //获取矩阵的行数   列数
        int row = array.length;
        int col = array[0].length;
        //获取每次循环打印的最后横纵坐标
        int endX = col - 1 - start;
        int endY = row - 1 - start;

        //如果超出最大的横纵坐标   不要打印  直接退出
        if (endX < start || endY < start) {
            return;
        }

        //处理特殊情况    只有一行 或只有一列
        if (endY == start) {
            for (int i = start; i <= endX; i++) {
                System.out.print(array[start][i] + " ");
            }
            return;
        }

        if (endX == start) {
            for (int i = start; i <= endY; i++) {
                System.out.print(array[i][start] + " ");
            }
            return;
        }

        //正常矩阵打印    顺时针循环打印
        //最上
        for (int i = start; i <= endX; i++) {
            System.out.print(array[start][i] + " ");
        }

        //最右
        for (int i = start + 1; i <= endY; i++) {
            System.out.print(array[i][endX] + " ");
        }

        //最下
        for (int i = endX - 1; i >= start; i--) {
            System.out.print(array[endY][i] + " ");
        }

        //最左
        for (int i = endY - 1; i >= start + 1; i--) {
            System.out.print(array[i][start] + " ");
        }

        //循环打印
        //递归算法打印
        print(array, start + 1);


    }


    public static void main(String[] args) {
        MyPrintMatrix myPrintMatrix = new MyPrintMatrix();
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        myPrintMatrix.printByArray(a);

    }

}
