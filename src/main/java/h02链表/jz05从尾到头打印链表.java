package h02链表;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目:输入一个链表的头节点, 从尾到头反过来打印每个节点的值
 * Create by @author sharpyangwei on 2021/8/2 - 下午8:38
 */
public class jz05从尾到头打印链表 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        SingleNode head;
        SingleNode headP;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        if (s.isEmpty()) {
            throw new RuntimeException("没有输入数据");
        }
        for (String s1 : split) {
            Integer integer = new Integer(s1);
            list.add(integer);
        }

        head = new SingleNode(list.get(0));
        head.next = null;
        headP = head;

        for (int i = 1; i < list.size(); i++) {
            SingleNode node = new SingleNode(list.get(i));
            node.next = null;
            headP.next = node;
            headP = node;//指针后移
        }

        //倒叙打印链表, 基于链表
        //        method1(head);

        //倒叙打印, 基于递归
        method2(head);
    }

    private static void method2(SingleNode head) {
        if (head != null && head.next != null) {
            method2(head.next);
        }
        System.out.print(head.value + " ");
    }

    private static void method1(SingleNode head) {
        Stack<Integer> nodes = new Stack<>();
        SingleNode temp = head;
        while (temp != null) {
            nodes.push(temp.value);
            temp = temp.next;//指针后移
        }

        //打印堆
        System.out.println("倒叙打印结果为: ");
        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop() + " ");
        }
    }
}

