package h03栈和队列;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 用两个栈实现队列, 完成appendTail(队尾插入节点) 和 deleteHead(队头删除节点)
 * Create by @author sharpyangwei on 2021/8/2 - 下午8:39
 */
public class jz07用两个栈实现队列 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        System.out.println("请输入数据");
        String s = scanner.nextLine();
        if (s.isEmpty()) {
            throw new RuntimeException("输入错误, 数据为空");
        }
        String[] split = s.split(" ");
        for (String s1 : split) {
            list.add(new Integer(s1));
        }

        //插入队列
        for (int i = 0; i < list.size() - 1; i++) {
            queue.appendTail(list.get(i));
        }

        if (!queue.isEmpty()) {
            System.out.println("删除一个元素");
            System.out.println(queue.deleteHead());
        }

        //插入一个元素
        System.out.println("插入一个元素");
        queue.appendTail(list.get(list.size() - 1));

        //删除队列
        System.out.println("删除队列");
        while (!queue.isEmpty()) {
            System.out.print(queue.deleteHead() + " ");
        }
    }
}
