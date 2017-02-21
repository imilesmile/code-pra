package sword;

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
    public static int solution1(int[] arr) {

        if (arr != null && arr.length > 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int CurrentSum = 0;
        int MaxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    CurrentSum += arr[k];
                }
                if (CurrentSum > MaxSum) {
                    MaxSum = CurrentSum;
                }
            }
        }
        return MaxSum;
    }

    /**
     * 穷举法优化
     * <p>
     * 算法二相较于算法一，其优化主要体现在减少了很多重复的操作。
     * 对于A-B-C-D这样一个序列，
     * 算法一在计算连续子序列和的时候，其过程为：
     * A-B、A-C、A-D、B-C、B-D、C-D
     * 而对于算法二，其过程为：
     * A-B、A-C、A-D、B-C、B-D、C-D
     * 其过程貌似是一样的，但是算法一的复杂就在于没有充分利用前面已经求出的子序列和的值。
     * 举个例子，算法一在求A-D连续子序列和的值时，其过程为A-D = A-B + B-C + C-D；
     * 而对于算法二，A-D连续子序列和的求值过程为A-D = A-C+C-D；
     * 这样，算法二充分利用了前面的计算值，这样就大大减少了计算子序列和的步骤。
     *
     * @param arr
     * @return
     */
    public static int solution2(int[] arr) {

        if (arr != null && arr.length > 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int CurrentSum = 0;
        int MaxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                CurrentSum += arr[j];//Sum(i, j+1) = Sum(i, j) + A[j+1]

                if (CurrentSum > MaxSum) {
                    MaxSum = CurrentSum;
                }
            }
        }
        return MaxSum;
    }


    /**
     * 动态规划法,时间复杂度O(N)
     * <p>
     * 将一个问题用动态规划方法处理的准则：
     * “最优子结构”、“子问题重叠”、“边界”和“子问题独立”。
     * <p>
     * 在本问题中，我们可以将子序列与其子子序列进行问题分割。
     * 最后得到的状态转移方程为：
     * MaxSum[i] = Max{ MaxSum[i-1] + A[i], A[i]};
     *
     * @param arr
     * @return
     */
    public static int solution3(int[] arr) {

        if (arr != null && arr.length > 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int CurrentSum = 0;
        int MaxSum = 0;

        for (int i = 0; i < arr.length; i++) {

        }
        return MaxSum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 98, 23, 56, 77};

        System.out.println(solution1(arr));
    }
}
