package sorts;


/**
 * 快速排序
 *
 * @Author: milo
 * @Create: 2017-02-13
 */
public class QuickSort {

    public void quickSort(int[] strDate, int left, int right) {
        int mid;
        int i, j;
        i = left;
        j = right;
        mid = strDate[(i + j) / 2];

        do {
            while (strDate[i] < strDate[mid] && strDate[i] < right)
                i++;//找出左边比中间值大的数
            while (strDate[j] > strDate[mid] && strDate[j] > left)
                j--;//找出右边比中间值小的数
            if (strDate[i] <= strDate[j]) {//将左边大的数和右边小的数进行替换
                int temp = i;
                i = j;
                j = temp;
                i++;
                j--;
            }
        } while (i <= j);//当两者交错时停止

        if (i < right) {
            quickSort(strDate, i, right);
        }

        if (j > left) {
            quickSort(strDate, left, j);
        }

    }

    public static void main(String[] args) {


        int[] strVoid = new int[]{11, 66, 22, 0, 55, 22, 0, 32};

        QuickSort sort = new QuickSort();

        sort.quickSort(strVoid, 0, strVoid.length - 1);

        for (int i = 0; i < strVoid.length; i++) {


            System.out.print(strVoid[i] + " ");
        }
    }
}
