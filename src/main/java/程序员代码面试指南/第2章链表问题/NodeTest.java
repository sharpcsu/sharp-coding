package 程序员代码面试指南.第2章链表问题;

import java.util.ArrayList;
import java.util.Scanner;

public class NodeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s1 : split) {
            Integer integer = new Integer(s1);
            list.add(integer);
        }
        
        Node node1 = new Node(list.get(0));
        Node head1 = node1;
        
        /**
         * 赋值
         */
        for (int i = 1; i < list.size(); i++) {
            Node node = new Node(list.get(i));
            node.next = null;
            node1.next = node;
            node1 = node1.next;
        }
        
        /**
         * 打印
         */
        while (head1 != null) {
            System.out.println(head1.val);
            System.out.println(head1.next);
            head1 = head1.next;
        }
    }
}
