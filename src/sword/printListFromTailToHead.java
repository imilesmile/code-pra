package sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class printListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.value);
        }

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{};
    }

}


class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}