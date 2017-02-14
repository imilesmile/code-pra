package sword;

import java.util.Stack;

/**
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @Author: milo
 * @Create: 2017-02-10
 */
public class StackWithMin {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    Integer temp = null;

    public void push(int node) {
        if (temp != null) {
            if (node <= temp) {
                temp = node;
                min.push(node);
            }
            data.push(node);
        } else {
            temp = node;
            data.push(node);
            min.push(node);
        }

    }

    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if (num != num2){
            min.push(num2);
        }
    }

    //public int top() {
    //
    //}
    //
    //public int min() {
    //}
}
