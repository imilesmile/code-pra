package zoubo;

/**
 * 最长公共子序列LCS
 * 一个二维矩阵
 * <p>
 * 变种:最长递增子序列
 * <p>
 * 动态规划问题
 * <p>
 * 例如:
 * 字符串13455与245576的最长公共子序列为455
 * 字符串acdfg与adfc的最长公共子序列为adf
 * <p>
 * 注意区别最长公共子串(Longest Common Substring)
 * 最长公共字串要求连续
 *
 * @Author: milo
 * @Create: 2017-02-22
 */
public class LongestCommonSub {

    //取得最长子序列的长度
    public static int[][] getLength(String[] x, String[] y) {
        int[][] b = new int[x.length][y.length];//记录方向,为输出做准备
        int[][] c = new int[x.length][y.length];

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                if (x[i] == y[j]) {//元素相等,取左上元素
                    c[i][j] = c[i - 1][j - 1] + 1; //取左上角元素
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {//元素不相等两种情况,左或上
                    c[i][j] = c[i - 1][j];//取上面的元素
                    b[i][j] = 0;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }

        return b;
    }

    //输出显示
    public static void Display(int[][] b, String[] x, int Alen, int Blen) {//回溯输出值,由于是公共的,找一个字符串输出就可以
        int i = Alen;
        int j = Blen;

        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            Display(b, x, i - 1, j - 1);//向左上角移动
            System.out.print(x[i] + " ");//输出左上角的值
        } else if (b[i][j] == 0) {
            Display(b, x, i - 1, j);//向上移动
        } else {
            Display(b, x, i, j - 1);//向左移动
        }
    }

    public static void main(String[] args) {
        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"", "B", "D", "C", "A", "B", "A"};
        int[][] b = getLength(x, y);
        Display(b, x, x.length - 1, y.length - 1);


    }
}
