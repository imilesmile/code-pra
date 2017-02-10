package sword;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;
import java.util.EmptyStackException;

import static oracle.jrockit.jfr.events.Bits.swap;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * <p>
 * 思路：
 * <p>
 * 可以使用双指针的方式，一个指针指向数组的开始，
 * 一个指针指向数组的尾部，如果头部的数为偶数且尾部的数是奇数则交换，
 * 否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class reOrderArray {

    //保证原顺序 类似冒泡算法，前偶后奇数就交换：
    public static void solution(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j>i; j++) {
                if (array[i]%2==0||array[j]%2==1){
                    swap(array[i],array[j]);
                }
            }
        }
    }

    private static void swap(int m, int n) {
        int temp = m;
        m =n;
        n= temp;
    }


    //保证原顺序
    public static void solution1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int low = 0;
        int high = array.length - 1;

        //两位置直到相遇
        while (low < high) {
            if (array[low] % 2 == 0 && array[high] % 2 == 1) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
                low++;
                high--;

            } else if (array[low] % 2 == 1) {//如果low位置上的为奇数,low后移
                low++;
            } else {//high位置上为偶数,high前移
                high--;
            }

        }

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        solution1(a);
        System.out.println(Arrays.toString(a));

    }
}
