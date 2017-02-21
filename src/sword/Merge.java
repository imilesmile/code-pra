package sword;

/**
 * 合并两个排序的链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * 思路：
 * 主要是链表中值的比较，取较小的结点插入到新的链表中。
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class Merge {

    public ListNode solution(ListNode list1, ListNode list2) {

        ListNode head;

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            head = list2;
        }

        if (list2 == null) {
            head = list1;
        }

        // node_1和node_2是用于遍历
        ListNode node_1 = list1;
        ListNode node_2 = list2;

        if (node_1.value < node_2.value) {
            head = node_1;
            head.next = solution(node_1.next, node_2);
        } else {
            head = node_2;
            head.next = (solution(node_1, node_2.next));
        }
        return head;
    }

}
