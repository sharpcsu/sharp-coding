package h02链表;

import java.util.Scanner;

/**
 * 题目:
 * 分别实现反转单向链表和双向链表
 *
 * 要求: 如果链表长度为N, 时间复杂度要求为O(N), 额外空间复杂度为O(1)
 * Created by sharp on 7/2 2017年7月24日14:11:37
 */
public class cx04反转单向和双向链表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    
//        Node head1 = SingleNodeUtils.str2link(str);
        TwoWayNode head2 = TwoWayNodeUtils.str2doubleNode(str);
        
        //反转单向链表
//        head1 = reverse(head1);
//        SingleNodeUtils.printLink(head1);
    
        //反转双向链表
        head2 = reverseDouble(head2);
        TwoWayNodeUtils.printTwoWayNode(head2);
    }
    
    /**
     * 反转单向链表
     * @param head 单向链表的头节点
     * @return 反转后的链表头节点
     */
    private static SingleNode reverse(SingleNode head) {
        SingleNode pre = null;
        SingleNode next = null;
        while (head != null) {
            next = head.next; //next后移
            head.next = pre; //指针反转
            
            pre = head; //pre后移
            head = next; //head后移
        }
        
        return pre;
    }
    
    /**
     * 反转双向链表
     * @param head 双向链表的头节点
     * @return 反转后的链表头节点
     */
    private static TwoWayNode reverseDouble(TwoWayNode head) {
        // TODO: 2017/7/24 双向链表还不会
        return null;
    }
}
