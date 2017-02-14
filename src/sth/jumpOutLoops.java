package sth;

/**
 * 跳出多层循环
 *
 * @Author: milo
 * @Create: 2017-02-14
 */
public class jumpOutLoops {

    /**
     * 让外层的循环条件表达式的结果可以受到里层循环体
     * 代码的控制，
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        boolean flag = false;
        /**
         * 注意!flag的用法
         */
        for (int i = 0; i < arr.length && !flag; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 5) {
                    flag = true;
                    break;
                }
            }
        }
    }
}
