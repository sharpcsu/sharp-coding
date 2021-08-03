package h03栈和队列;

import java.util.Stack;

/**
 * Create by @author sharpyangwei on 2021/8/3 - 上午10:31
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * 从队尾插入节点
     */
    public void appendTail(int value) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }

        in.push(value);
    }

    /**
     * 从队头删除节点
     */
    public int deleteHead() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        return out.pop();
    }

    //入队列
    public void push(int n) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }

        in.push(n);
    }

    //出队列
    public int pop() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        return out.pop();
    }

    //返回队列头的数据
    public int peek() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

}
