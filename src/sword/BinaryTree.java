package sword;

/**
 * 二叉树
 * <p>
 * 二叉树的遍历
 * 从二叉树的递归定义可知，一棵非空的二叉树由根结点及左、右子树这三个基本部分组成。因此，在任一给定结点上，可以按某种次序执行三个操作：
 * 　（1）访问结点本身(N)，
 * 　（2）遍历该结点的左子树(L)，
 * 　（3）遍历该结点的右子树(R)。
 * 以上三种操作有六种执行次序：
 * 　NLR、LNR、LRN、NRL、RNL、RLN。
 * 注意：
 * 前三种次序与后三种次序对称，故只讨论先左后右的前三种次序。
 * 　　由于被访问的结点必是某子树的根，所以N(Node)、L(Left subtlee)和R(Right subtree)
 * 又可解释为根、根的左子树和根的右子树。NLR、LNR和LRN分别又称为先根遍历、中根遍历和后根遍历。
 * <p>
 * <p>
 * 树结合了两种数据结构的有点：一种是有序数组，树在查找数据项的速度和在有序数组中查找一样快；另一种是链表，树在插入数据和删除数据项的速度和链表一样。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */


public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 递归创建二叉树
     */
    public void buildTree(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    buildTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(data);
                } else {
                    buildTree(node.right, data);
                }
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 12, 45, 21, 6, 111};
        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < a.length; i++) {
            binaryTree.buildTree(binaryTree.root, a[i]);
        }
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
    }


    /**
     * 二叉树节点
     */
    private class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

}