package sth;

/**
 * 大数相加
 * <p>
 * 1.反转两个字符串，便于从低位到高位相加和最高位的进位导致和的位数增加；
 * <p>
 * 2.对齐两个字符串，即短字符串的高位用‘0’补齐，便于后面的相加；
 * <p>
 * 3.把两个正整数相加，一位一位的加并加上进位。
 *
 * @Author: milo
 * @Create: 2017-02-21
 */
public class bigNumSum {

    public static String NumSum(String n1, String n2) {

        if (n1 == null || n2 == null || n1.length() == 0 || n2.length() == 0) {
            return null;
        }

        if (n1.length() == 0) {
            return n2;
        }

        if (n2.length() == 0) {
            return n1;
        }

        //反转两个字符串得到数组
        char[] a = new StringBuffer(n1).reverse().toString().toCharArray();
        char[] b = new StringBuffer(n2).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;

        //计算出两个字符串最长的长度加1,并将短数组用0补齐
        int len = lenA > lenB ? lenA : lenB;

        int[] result = new int[len + 1];// 长度为len＋1（因为可能有进位）

        for (int i = 0; i < len + 1; i++) {

            // 如果当前的i超过了其中的一个，就用0代替，和另一个字符数组中的数字相加
            // 注意(a[i] - '0')的用法
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;

            result[i] = aint + bint;

        }
        //处理结果集合,如果大于10就向前进一位
        for (int j = 0; j < result.length; j++) {
            if (result[j] >= 10) {
                result[j + 1] += result[j] / 10;
                result[j] %= 10;
            }
        }
        //反转字符串
        StringBuffer sb = new StringBuffer();
        boolean flag = true;// 该字段用于标识是否有前置0，如果有就不要存储
        for (int k = 0; k < result.length; k++) {
            if (result[k] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[k]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        String s = NumSum("12314241", "234234245");

        System.out.println("----------------------s值=" + s + "," + "当前类是=bigNumSum.main()");

    }
}
