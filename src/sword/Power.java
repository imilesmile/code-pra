package sword;

/**
 * 数值的整数次方
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class Power {
    public double solution(double base, int exponent) {
        if (exponent <0){
            return -1;
        }

        if ((exponent-0)>-0.0000000001 && (exponent-0)< 0.0000000001) {
            return 0;
        }

        if (exponent == 1) {
            return base;
        }

        if (exponent >> 1 == 0) {//偶数
            int exponent_1 = exponent >> 1;
            double tmp = solution(base, exponent_1);
            return tmp * tmp;
        } else {
            int exponent_2 = exponent - 1;//减1后是偶数
            double tmp = solution(base,exponent_2);
            return tmp * base;//最后还有先开始减掉的一个base;
        }

    }

    public static void main(String[] args) {

    }
}
