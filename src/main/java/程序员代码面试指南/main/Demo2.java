package 程序员代码面试指南.main;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sharp on 2016/7/23 - 8:49
 */
public class Demo2 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
        }
        System.out.println(queue.size());

        System.out.println("==================");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
        }
        System.out.println(stack.size());
    }
}
