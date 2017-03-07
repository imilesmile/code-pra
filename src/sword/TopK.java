package sword;

/**
 * 最大k个数
 * <p>
 * BuildHeap：将普通数组转换成堆，转换完成后，数组就符合堆的特性：所有父节点的值小于或等于两个子节点的值。
 * <p>
 * Heapify(int i)：当元素i的左右子树都是小根堆时，通过Heapify让i元素下降到适当的位置，以符合堆的性质。
 * <p>
 * 回到上面的取TopK问题上，用最小堆的解决方法就是：先去源数据中的K个元素放到一个长度为K的数组中去，
 * 再把数组转换成最小堆。再依次取源数据中的K个之后的数据和堆的根节点（数组的第一个元素）比较，根据最小堆的性质，
 * 根节点一定是堆中最小的元素，如果小于它，则直接pass，大于的话，就替换掉跟元素，并对根元素进行Heapify，
 * 直到源数据遍历结束。
 *
 * @Author: milo
 * @Create: 2017-02-27
 */
public class TopK {
    public static void main(String[] args) {
        // 源数据
        int[] data = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};

// 获取Top5
        int[] top5 = topK(data, 3);

        for (int i = 0; i < 3; i++) {
            System.out.println(top5[i]);
        }
    }

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data, int k) {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }
        return topk;
    }
}

class MinHeap {
    // 堆的存储结构 - 数组
    private int[] data;

    // 将一个数组传入构造方法，并转换成一个小根堆
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    // 将数组转换成最小堆
    private void buildHeap() {
        // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            // 对有孩子结点的元素heapify
            heapify(i);
        }
    }

    private void heapify(int i) {
        // 获取左右结点的数组下标
        int l = left(i);
        int r = right(i);

        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallest = i;

        // 存在左结点，且左结点的值小于根结点的值
        if (l < data.length && data[l] < data[i])
            smallest = l;

        // 存在右结点，且右结点的值小于以上比较的较小值
        if (r < data.length && data[r] < data[smallest])
            smallest = r;

        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == smallest)
            return;

        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, smallest);

        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }

    // 获取右结点的数组下标
    private int right(int i) {
        return (i + 1) << 1;
    }

    // 获取左结点的数组下标
    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    // 交换元素位置
    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 获取对中的最小的元素，根元素
    public int getRoot() {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }
}