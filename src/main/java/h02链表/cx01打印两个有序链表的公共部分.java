package h02链表;

import java.util.Scanner;

/**
 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 *
 * Created by sharp on 7/2 0002 - 13:23
 */
public class cx01打印两个有序链表的公共部分 {
    public static void main(String[] args) {
        //获取链表
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        //转换成链表
        SingleNode head1 = SingleNodeUtils.str2link(s1);
        SingleNode head2 = SingleNodeUtils.str2link(s2);

        //打印公共部分
        printLink(head1, head2);
    }

    public static void printLink(SingleNode head1, SingleNode head2) {
        if(head1 == null || head2 == null) {
            return;
        }

        SingleNode p1 = head1;
        SingleNode p2 = head2;

        while((p1 != null) && (p2 != null)) {
            if(p1.value < p2.value) {
                p1 = p1.next;
            } else if(p1.value > p2.value) {
                p2 = p2.next;
            } else {
                System.out.print(p1.value + "\t");
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }
}
