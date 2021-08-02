package h02链表;

import java.util.Scanner;

/**
 * 删除链表的中间节点和a/b处的节点, 两个方法
 *
 * Created by sharp on 2017年7月23日17:12:15
 */
public class cx03删除链表的中间节点和a_b处的节点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        SingleNode h1 = SingleNodeUtils.str2link(str);
        SingleNode h2 = SingleNodeUtils.str2link(str);
    
        //删除链表的中间处的节点
//        Node head1 = deleteMiddle(h1);
//        SingleNodeUtils.printLink(head1);
        
        //删除a/b处的节点
        SingleNode head2 = deleteA_B(h2, a, b);
        SingleNodeUtils.printLink(head2);
    }
    
    /**
     * 删除链表中间的节点
     * @param head 链表的头节点
     * @return 链表的头节点
     */
    private static SingleNode deleteMiddle(SingleNode head) {
        //链表为null或者只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
    
        //链表只有2个节点
        if (head.next.next == null) {
            return head.next;
        }
        
        //链表有三个或者3个以上节点
        SingleNode pre = head;
        SingleNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        
        //删除per的下一个节点
        pre.next = pre.next.next;
        
        return head;
    }
    
    /**
     * 删除链表中a/b处的节点
     * @param head 链表的头节点
     * @param a a
     * @param b b
     * @return 链表的头节点
     */
    private static SingleNode deleteA_B(SingleNode head, int a, int b) {
        //合法性判断
        if (head == null ||a < 1 || a > b) {
            return head;
        }
        
        //统计节点的个数
        int num = 0;
        SingleNode cur = head;
        while (cur != null) {
            num++;
            cur = cur.next;
        }
        
        //计算要删除的节点的位置
        num = (int)Math.ceil((double) (num * a) / (double) b);
    
        cur = head;
        for (int i = 0; i < num - 2; i++) {
            cur = cur.next;
        }
        
        cur.next = cur.next.next;
        
        return head;
    }
}
