package h02链表;

import java.util.Scanner;

import 程序员代码面试指南.第2章链表问题.NodeUtils;

/**
 * 题目:
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * <p>
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * <p>
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 * <p>
 * 思路解析:
 * 创建三个链表分别是小于val, 等于val,大于val, 然后合并.
 * <p>
 * Created by sharp on 2017年7月17日22:20:59
 */
// TODO: 7/18 0018 节点的初始化指向问题
// TODO: 7/18 0018 没有完成
public class nk05链表分化 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
        
        Node head = NodeUtils.str2link(str);
        
        //打印链表
        NodeUtils.printLink(head);
        
        Node res = listDivide(head, val);
        
        //打印链表
        
        NodeUtils.printLink(res);
    }
    
    public static Node listDivide(Node head, int val) {
        if (head == null) {
            return null;
        }
        
        Node pre = null;
        Node post = null;
        
        //相应的头节点
        Node preHead = pre;
        Node postHead = post;
        
        while (head != null) {
            if (head.val <= val) {
                if (pre == null) {
                    pre = head;
                    preHead = pre;
                } else {
                    pre.next = head;//节点的next指向下一个节点
                    pre = pre.next;//指针后移
                }
            } else {
                if (post == null) {
                    post = head;
                    postHead = post;
                } else {
                    post.next = head;//节点的next指向下一个节点
                    post = post.next;//指针后移
                }
            }
            
            head = head.next; //节点后移
        }
        
        //截断三个链表的next
        if (pre != null) {
            pre.next = null;
        }
        
        if (post != null) {
            post.next = null;
        }
        
        
        //合并三个链表, 注意区分指针和节点本身
        Node index = null;
        if (preHead != null) {
            head = preHead;
            index = pre;
        }
    
        if (postHead != null) {
            if (head == null) {
                head = postHead;
                index = post;
            } else {
                index.next = postHead;
            }
        }
        
        return head;
    }
}
