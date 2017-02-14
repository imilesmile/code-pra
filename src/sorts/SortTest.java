package sorts;

import static sorts.BubbleSort.bubbleSort;
import static sorts.SelectionSort.selectionSort;

/**
 * 测试类
 *
 * @Author: milo
 * @Create: 2017-02-13
 */
public class SortTest {
    public static void main(String[] args) {
        int[] array = {1, 4, 4, 16, 7, 24, 23, 98};


        //bubbleSort(array);
        selectionSort(array);


        for (int i = 0; i < array.length; i++) {
            if (i == array.length) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ",");
            }
        }
    }
}
