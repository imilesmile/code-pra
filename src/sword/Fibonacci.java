package sword;

/**
 * Fibonacci
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * <p>
 * n<=39
 * 用递归实现的过程中会出现重复计算的情况，此时，可以利用动态规划的思想，保存中间结果，这样可以避免不必要的计算。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class Fibonacci {

    public static int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            //由zero和one保存中间结果
            int zero = 0;
            int one = 1;
            int fN = 0;

            for (int i = 2; i <= n; i++) {
                fN = one + zero;
                zero = one;
                one = fN;
            }
            return fN;
        }

    }

    public static void main(String[] args) {
        int n = 2;
        int solution = solution(n);
        System.out.println(solution);
    }
}
