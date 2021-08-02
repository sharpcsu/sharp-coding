package h02链表;

import java.util.Scanner;

/**
 * 题目:
 * 给定一个单向链表的头节点head, 以及两个整数from 和 to, 在单向链表上把第from个节点到第to个节点这一部分进行反转.
 *
 * 要求:
 * 1. 如果链表长度为N, 时间复杂度为O(N), 额外空间复杂度为O(1)
 * 2. 如果不满足1 <= from <= to <= N, 则不用调整
 *
 * Created by sharp on 2017年7月24日14:11:47
 */
public class cx05反转部分单向链表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int from = scanner.nextInt();
        int to = scanner.nextInt();
    
        SingleNode head = SingleNodeUtils.str2link(str);
        head = reverseFromAndTo(head, from, to);
        SingleNodeUtils.printLink(head);
    }
    
    /**
     * 反转部分链表
     * @param head 单向链表的头节点
     * @param from 反转的起始位置
     * @param to 反转的结束位置
     * @return 反转后的链表
     */
    private static SingleNode reverseFromAndTo(SingleNode head, int from, int to) {
        //合法性判断
        if (head == null || from <= 0 || to >= 0 || from > to) {
            return head;
        }
        
        int len = 0;
        SingleNode fPre = null;
        SingleNode tPos = null;
        SingleNode cur = head;
    
        while (cur != null) {
            len++;
            fPre = (len == from - 1) ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            
            cur = cur.next;
        }
    
//        if () {
//        }
        
        
        return null;
    }
}
