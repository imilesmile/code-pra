package sword;


/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class reConstructBinaryTree {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        //创建根节点，根节点肯定是前序遍历的第一个数
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i < endIn; i++) {
            //找到中序遍历根节点所在位置,存放于变量gen中
            if (in[i] == pre[startPre]) {
                //对于中序遍历，根节点左边的节点位于二叉树的左边，根节点右边的节点位于二叉树的右边
                //和shell排序的思想类似，取出前序和中序遍历根节点左边和右边的子树
                //递归，再对其进行上述所有步骤，即再区分子树的左、右子子数，直到叶节点
                //前序第一个为根节点
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }

    }

}


