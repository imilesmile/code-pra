package sword;

/**
 * 二进制中1的个数
 * <p>
 * 题目大致为：
 * 实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 思路：
 * 把一个整数减去1，再和原整数做与运算，会把最右边一个1编程0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class NumberOf1 {

    public static int solution(int n) {

        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>= 1;
        }
        return count;
    }

    public static int solution1(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(solution(n));

    }
}
