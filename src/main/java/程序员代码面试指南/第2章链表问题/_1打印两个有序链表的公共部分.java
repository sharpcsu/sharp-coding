package 程序员代码面试指南.第2章链表问题;

import java.util.Scanner;

/**
 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 *
 * Created by sharp on 7/2 0002 - 13:23
 */
public class _1打印两个有序链表的公共部分 {
    public static void main(String[] args) {
        //获取链表
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        //转换成链表
        Node head1 = NodeUtils.str2link(s1);
        Node head2 = NodeUtils.str2link(s2);

        //打印公共部分
        printLink(head1, head2);
    }

    public static void printLink(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return;
        }

        Node p1 = head1;
        Node p2 = head2;

        while((p1 != null) && (p2 != null)) {
            if(p1.val < p2.val) {
                p1 = p1.next;
            } else if(p1.val > p2.val) {
                p2 = p2.next;
            } else {
                System.out.print(p1.val + "\t");
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }
}
