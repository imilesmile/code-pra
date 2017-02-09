package sword;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class minNumberInRotateArray {

    public static int solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int low = 0;
        int high = array.length - 1;
        int mid = low;

        while (array[low] >= array[high]) {
            //数组中就只有两个数,最小的为后者
            if (high - low == 1) {
                mid = high;
                break;
            }

            //查找中间位置
            mid = (high + low) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {

        int[] array = {1, 1, 0, 1, 1, 1};
        int solution = solution(array);
        System.out.println(solution);
    }

}
