package sword;

/**
 * 合并链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * @Author: milo
 * @Create: 2017-02-16
 */
public class ListMerge {

    public ListNode solution(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        //新建一个头节点，用来存合并的链表
        ListNode mergeHead = null;
        ListNode current = null;

        while (list1 != null && list2 != null) {

            if (list1.value <= list2.value) {
                if (mergeHead == null) {
                    mergeHead = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }

        }

        //把未结束的链表连接到合并后的链表尾部
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return mergeHead;
    }

}
