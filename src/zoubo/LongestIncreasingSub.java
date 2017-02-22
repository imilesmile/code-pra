package zoubo;


import java.util.Arrays;

import static java.util.Arrays.binarySearch;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * 最长递增子序列
 *
 * @Author: milo
 * @Create: 2017-02-22
 */
public class LongestIncreasingSub {


    //时间复杂度为O(N2)
    public int solution1(int[] array) {

        int[] LIS = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            LIS[i] = 1;                                 //初始化默认的长度
            for (int j = 0; j < i; j++) {               //找出前面最长的序列
                if (array[i] > array[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        return max(LIS);
    }

    /**
     * 动态规划
     * <p>
     * 要么是只包含ai的子序列
     * 要么是在满足j<i并且aj<ai的以ai为结尾的递增子序列末尾，追加上ai后得到的子序列
     *
     * @param array
     * @return
     */
    public int solution2(int[] array) {
        //记录数组中的递增序列的信息
        int[] MaxV = new int[array.length + 1];

        MaxV[1] = array[0]; //数组中的第一个值边界值
        MaxV[0] = Min(array) - 1;//数组中最小值边界值

        int[] LIS = new int[array.length];

        //初始化最长递增序列的信息
        for (int i = 0; i < LIS.length; i++) {
            LIS[i] = 1;
        }

        int nMaxLIS = 1;//数组最长递增子序列的长度

        for (int i = 1; i < array.length; i++) {
            //遍历历史最长递增序列的信息
            int j;

            for (j = nMaxLIS; j >= 0; j--) {
                if (array[i] > MaxV[j]) {
                    LIS[i] = j + 1;
                    break;
                }
            }

            //如果当前最长序列大于最长递增序列的长度,更新最长信息
            if (LIS[i] > nMaxLIS) {
                nMaxLIS = LIS[i];
                MaxV[LIS[i]] = array[i];
            } else if (MaxV[j] < array[i] && array[i] < MaxV[j + 1]) {
                MaxV[j + 1] = array[i];
            }
        }
        return nMaxLIS;
    }

    private int Min(int[] array) {
        int min = 0;
        return min;
    }


    public static int max(int[] LIS) {

        int max = 0;

        return max;
    }


    /**
     * arr = {2 1 5 3 6 4 8 9 7}
     * <p>
     * 首先i=1, 遍历到1， 1 通过跟MaxV[nMaxLength]比较: 1<MaxV[nMaxLength],
     * 发现1更有潜力（更小的有潜力，更小的替换之）
     * 1 更有潜力, 那么1就替换MaxV[nMaxLength] 即 MaxV[nMaxLength] =1 ;
     * 这个时候 MaxV={1}， nMaxlength = 1，LIS[1] = 1;
     * <p>
     * 然后 i =2, 遍历到5， 5通过跟MaxV[nMaxLength]比较, 5>MaxV[nMaxLength],
     * 发现5 更大； 链接到目前得到的LIS尾部；
     * 这个时候 MaxV={1，5}， nMaxlength++ = 2， MaxV[nMaxLength]=5， LIS[i] = 1+1 = 2;
     * <p>
     * 然后 i =3，遍历到3, 3 通过跟MaxV[nMaxLength]比较, 3<MaxV[nMaxLength],
     * 发现3更有 潜力，然后从 nMaxLength往前比较，找到第一个刚刚比3大元素替换之。（稍后解释什么叫刚刚大）
     * 这个时候 MaxV={1,3}， nMaxlength = 2; 3只是替换， LIS[i]不变 = LIS[3]= 2;
     * <p>
     * 然后 i =4，遍历到6， 6 通过跟 MaxV[nMaxLength]比较, 6>MaxV[nMaxLength],
     * 发现6更大； 6就应该链接到目前得到的LIS尾部；
     * 这个时候，MaxV={1,3,6} ，nMaxlength = 3，MaxV[nMaxLength+1]=6 , LIS[4] = 3
     * <p>
     * 然后i =5，遍历到4, 4 通过跟MaxV[nMaxLength] = 6比较, 4<MaxV[nMaxLength],
     * 发现4更有潜力，然后从nMaxLength往前比较，找到刚刚比4大元素 也就是 6替换之。
     * 这个时候 MaxV={1,3,4}， nMaxlength = 3，4只是替换， LIS[i]不变 = LIS[5]= 3;
     * <p>
     * 然后i=6, 遍历到8， 8通过跟MaxV[nMaxLength]比较, 8>MaxV[nMaxLength],
     * 发现8更大； 8就应该链接到目前得到的LIS尾部；
     * 这个时候 MaxV={1,3,4,8}， nMaxlength = 4, Maxv[nMaxlength]=8 LIS[6]=4,
     * <p>
     * 然后i=7, 遍历到9， 9通过跟MaxV[nMaxLength]比较, 9>MaxV[nMaxLength],
     * 发现9更大； 9就应该链接到目前得到的LIS尾部；
     * 这个时候 MaxV={1,3,4,8，9}， nMaxlength = 5, Maxv[nmaxlength]=9, LIS[7] = 5;
     * <p>
     * 然后i=8, 遍历到7, 7 通过跟MaxV[nMaxLength] = 9比较, 7<MaxV[nMaxLength],
     * 发现7更有潜力，然后从nMaxLength往前比较，找到第一个比7大元素 也就是 8替换之。
     * 这个时候 MaxV={1,3,4,7,9}, nMaxLength = 5, Maxv[nMaxlength]=9
     * LIS[8] = LIS[替换掉的index] = 4;
     * <p>
     * <p>
     * -- 	    2 	1 	5 	    3 	    6 	    4 	    8 	        9 	        7
     * i 	    1 	2 	3 	    4 	    5 	    6 	    7 	        8 	        9
     * LIS 	    1 	1 	2 	    2 	    3 	    3 	    4 	        5 	        4
     * MaxV 	2 	1 	1,5 	1,3 	1,3,6 	1,3,4 	1,3,4,8 	1,3,4,8,9 	1,3,4,7
     * <p>
     * <p>
     * MaxV里面的数组下标代表了长度为index的最长子序列末尾元素，反过来就是末尾元素在MaxV里对应的下标就是他子序列的长度
     *
     * @param arr
     * @return
     */
    public int solution3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        //辅助变量
        int[] MaxV = new int[arr.length + 1];//记录递增子序列LIS的末尾元素最小值
        int nMaxLength = 1;//当前LIS的长度
        int[] LIS = new int[arr.length + 1];//LIS[i]记录的是以第i个元素为结尾的最长序列的长度
        //初始化
        MaxV[0] = -100;
        MaxV[nMaxLength] = arr[0];
        LIS[0] = 0;
        LIS[1] = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > MaxV[nMaxLength]) {
                MaxV[++nMaxLength] = arr[i];
                LIS[i] = LIS[i - 1] + 1;
            } else {
                //新元素 更小,更有"潜力",替换大的元素
                int index = binarySearch(MaxV, arr[i], 0, nMaxLength);
                //*
                LIS[i] = index;
                MaxV[index] = arr[i];
            }
        }
        Arrays.sort(LIS);
        return LIS[LIS.length - 1];

    }

    public static void main(String[] args) {

    }

}
