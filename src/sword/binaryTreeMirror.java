package sword;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class binaryTreeMirror {
    public static void mirrorRecursively(BinaryTreeNode root) {
        //树为空
        if (root == null) {
            return;
        }
        //只有一个根节点
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTreeNode treeTmp = root.left;
        root.left = root.right;
        root.right = treeTmp;

        if (root.left != null) {
            mirrorRecursively(root.left);
        }

        if (root.right != null) {
            mirrorRecursively(root.right);
        }

    }
}
