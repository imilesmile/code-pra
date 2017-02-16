package sth;

import sun.security.util.Length;

/**
 * 数组倒序
 *
 * @Author: milo
 * @Create: 2017-02-15
 */
public class ArrayReverse {

    public static void swap(int a[]) {
        int len = a.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;

        }
    }
}
