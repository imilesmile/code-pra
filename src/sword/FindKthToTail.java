package sword;

/**
 * 链表中倒数第k个结点
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class FindKthToTail {
    public static ListNode solution(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode prePoint = head;
        ListNode postPoint = head;

        for (int i = 0; i < k - 1; i++) {
            if (prePoint.getNext() != null) {
                prePoint = prePoint.getNext();
            } else {
                return null;
            }

        }

        while (prePoint.getNext() != null) {
            prePoint = prePoint.getNext();
            postPoint = postPoint.getNext();
        }
        return postPoint;
    }

    public static void main(String[] args) {
        //构建链表
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        head.setNext(h1);
        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);
        h5.setNext(null);

        ListNode p = solution(head, 3);
    }
}
