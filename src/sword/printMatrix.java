package sword;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * /*解题思路：顺时针打印就是按圈数循环打印，
 * 一圈包含两行或者两列，在打印的时候会出现某一圈中只包含一行，
 * 要判断从左向右打印和从右向左打印的时候是否会出现重复打印，同样只包含一列时，
 * 要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        //定义四个关键变量,表示左上和右下的打印范围
        int left = 0;
        int top = 0;
        int right = col;
        int bottom = row;
        while (left <= right && top <= bottom) {
            //left to right
            for (int i=left;i<=right;++i)

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    }
}
