package sword;

/**
 * 二维数组中的查找
 * 在一个二维数组中， 每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的
 * 顺序排序。 请完成一个函数， 输入这样的一个二维数组和一个整数， 判断数组中是否含有该
 * 整数。
 * 输入描述 :
 * array：待查找的二维数组
 * target ：查找的数字
 * 输出描述 :
 * 查找到返回 true ，查找不到返回 false
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class twoDimensionIndex {
    public static boolean find(int target, int[][] array) {

        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int num = array[i][j];
                if (target == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 把每一行看成有个有序的递增数组,
     * 利用二分查找
     * 通过遍历没一行得到答案
     * 时间复杂度是nlogn
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean solution1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用二维数组由上到下，由左到右递增的规律，
     * 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
     * 即col--；
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
     * 即row++；
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean solution2(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {

            } else {

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int target = 5;
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //boolean b = twoDimensionIndex.find(target, array);

        boolean b = twoDimensionIndex.solution1(target, array);
        System.out.println("----------------------b值=" + b + "," + "当前类是=twoDimensionIndex.main()");

    }
}
