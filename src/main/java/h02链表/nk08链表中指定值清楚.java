package h02链表;

import java.util.Scanner;

/**
 * 题目:
 * <p>
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * <p>
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 * <p>
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 * <p>
 * Created by sharp on 2017/7/18 - 15:23
 */
public class nk08链表中指定值清楚 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
        
        Node head = SingleNodeUtils.str2link(str);
        head = clear(head, val);
        
        SingleNodeUtils.printLink(head);
    }
    
    public static Node clear(Node head, int val) {
        //合法性判断
        if (head == null) {
            return null;
        }
        
        Node pre = null;
        Node index = head;
    
        while (index != null) {
            if (index.val == val) { //删除
                if (pre == null) { //pre为null是head后移
                    head = head.next;
                } else {
                    pre.next = index.next; //pre不为null时删除
                }
            } else {
                pre = index; //不删除时pre后移
            }
            
            index = index.next; //index后移
        }
        
        return head;
    }
}
