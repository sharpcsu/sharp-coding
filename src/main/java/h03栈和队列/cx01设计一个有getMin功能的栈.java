package h03栈和队列;

import java.util.Stack;

/**
 * 题目:
 * 实现一个特殊的栈, 在实现栈的基本功能的基础上, 再实现返回栈中最小元素的操作。
 * <p>
 * 要求：
 * 1. pop、push、getMin操作的时间复杂度都是O(1)。
 * 2. 设计的栈类型可以使用现场的栈结构。
 * <p>
 * Created by sharp on 7/2 0002 - 13:11
 */
public class cx01设计一个有getMin功能的栈 {
    public static void main(String[] args) {
//        MyStack1 mystack1 = new MyStack1();
//        mystack1.push(3);
//        mystack1.push(4);
//        mystack1.push(5);
//
//        System.out.println("最小值： " + mystack1.getMin());
//
//        mystack1.push(1);
//
//        System.out.println("弹出: " + mystack1.pop());
//        System.out.println("最小值: " + mystack1.getMin());
//
//        mystack1.push(2);
//        mystack1.push(1);


        MyStack2 mystack2 = new MyStack2();
        mystack2.push(3);
        mystack2.push(4);
        mystack2.push(5);

        System.out.println("最小值： " + mystack2.getMin());

        mystack2.push(1);

        System.out.println("弹出: " + mystack2.pop());
        System.out.println("最小值: " + mystack2.getMin());

        mystack2.push(2);
        mystack2.push(1);

    }
}

/**
 * 解法1
 */
class MyStack1 {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    /**
     * 入栈
     * <p>
     * 入栈的同时最小值也要入栈，如果data比最小值小则入栈，否则不入栈
     *
     * @param data
     */
    public void push(int data) {
        stackData.push(data);

        if (stackMin.size() == 0) {
            stackMin.push(data);
        } else if (data <= stackMin.peek()) {
            stackMin.push(data);
        }
    }

    /**
     * 出栈
     * <p>
     * 如果stackMin的栈顶元素比data大则出栈
     *
     * @return
     */
    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("数据为空");
        }

        int data = stackData.pop();
        if (data <= stackMin.peek()) {
            stackMin.pop();
        }

        return data;
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public int getMin() {
        if (stackMin.isEmpty() || stackData.isEmpty()) {
            throw new RuntimeException("数据为空");
        }

        int data = stackMin.peek();
        return data;
    }
}


class MyStack2 {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

/**
 * 入栈,min较小的值入栈
 *
 * @param data
 */
public void push(int data) {
    stackData.push(data);

    if (stackMin.isEmpty()) {
        stackMin.push(data);
    } else if (data < stackMin.peek()) {
        stackMin.push(data);
    } else {
        stackMin.push(stackMin.peek());
    }
}

/**
 * 出栈， min也要一起出栈
 *
 * @return
 */
public int pop() {
    if (stackData.isEmpty() || stackMin.isEmpty()) {
        throw new RuntimeException("数据为空");
    }

    stackMin.pop();
    return stackData.pop();
}

/**
 * 获取最小值， 从min中peek
 *
 * @return
 */
public int getMin() {
    return stackMin.peek();
}
}
