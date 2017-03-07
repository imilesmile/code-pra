package zoubo;

/**
 * 最大连续子序列和
 *
 * @Author: milo
 * @Create: 2017-02-17
 */
public class MaxSubSequence {

    /**
     * 穷举法:时间复杂度o(N3)
     *
     * @param arr
     * @return
     */
    //暴力法
    public static int solution1(int[] arr) {

        int maxSum = -10000;
        int currentSum;

        if (arr == null || arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }

            }
        }
        return maxSum;
    }

    //改进法
    public static int solution2(int[] arr) {

        int maxSum = -100000;
        int currentSum;

        if (arr == null || arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }


    /**
     * 动态规划法,时间复杂度O(N)
     * <p>
     * 将一个问题用动态规划方法处理的准则：
     * “最优子结构”、“子问题重叠”、“边界”和“子问题独立”。
     * <p>
     * 在本问题中，我们可以将子序列与其子子序列进行问题分割。
     * 最后得到的状态转移方程为：.≥
     * MaxSum[i] = Max{ MaxSum[i-1] + A[i], A[i]};
     *
     * @param arr
     * @return
     */
    public static int solution3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[] start = new int[arr.length];
        int[] all = new int[arr.length];

        start[len - 1] = arr[len - 1];
        all[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {//从数组末尾往前遍历,直到数组首
            start[i] = max(arr[i], arr[i] + start[i + 1]);
            all[i] = max(start[i], all[i + 1]);

        }
        return all[0];//遍历完数组,all[0]中存放着结果
    }

    public static int solution4(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int nStart = arr[len - 1];
        int nAll = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            nStart = max(arr[i], nStart + arr[i]);
            nAll = max(nStart, nAll);
        }
        return nAll;
    }

    public static int solution5(int[] arr) {
        int sub = arr[0];
        int maxsub = arr[0];

        for (int i = 2; i <= arr.length; i++) {
            sub = max(arr[i - 1], sub + arr[i - 1]);
            maxsub = max(sub, maxsub);
        }
        return maxsub;
    }


    public static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 6, -98, 23, 56, 77,90};

        System.out.println(solution5(arr));
    }
}
