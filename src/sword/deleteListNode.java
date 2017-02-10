package sword;

/**
 * 在O(1)时间删除链表结点
 * 题目大致为：
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class deleteListNode {

    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }

        //找到要删除节点的下一个节点.
        if (toBeDeleted.getNext() != null) {
            ListNode p = toBeDeleted.getNext();
            toBeDeleted.setValue(p.getValue());
            //删除p节点
            toBeDeleted.setNext(p.getNext());
        } else if (head == toBeDeleted) {
            //如果头结点就是要删除的节点
            head = null;
        } else {
            //删除尾节点
            ListNode currentNode = head;//用于遍历链表
            while (currentNode.getNext() != toBeDeleted) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
    }
}
