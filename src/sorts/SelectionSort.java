package sorts;

/**
 * 选择排序
 *
 * @Author: milo
 * @Create: 2017-02-13
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
