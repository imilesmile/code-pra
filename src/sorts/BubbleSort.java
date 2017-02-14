package sorts;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 冒泡排序
 *
 * @Author: milo
 * @Create: 2017-02-13
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (arr.length == 1) {
            return;
        }


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//易错点
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }
}
