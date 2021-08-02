package 剑指offer.h3高质量代码;

import java.util.Scanner;


/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 例如输入链表1和链表2，则合并之后的升序链表如链表3所示。
 *
 * @author sharp
 *         时间:2017-5-29 下午3:03:25
 */
public class jz17合并两个排序的链表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个链表:");
        
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        
        Node head1 = 生成链表(str1);
        //		System.out.println("打印链表1");
        //		打印链表(head1);
        
        Node head2 = 生成链表(str2);
        //		System.out.println("打印链表2");
        //		打印链表(head2);
        //		Node head3 = 递归法(head1, head2);
        //		System.out.println("打印链表3");
        //		打印链表(head3);
        
        Node head4 = 不对错了循环法(head1, head2);
        System.out.println("打印链表4");
        打印链表(head4);
        
        //		System.out.println("******=======================******");
        
        //		System.out.println("打印链表1");
        //		打印链表(head1);
        //		System.out.println("打印链表2");
        //		打印链表(head2);
        //		System.out.println("打印链表3");
        //		打印链表(head3);
    }
    
    private static Node 不对错了循环法(Node h1, Node h2) {
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }
        
        Node head1 = new Node(h1.value);
        head1.next = h1.next;
        Node head2 = new Node(h2.value);
        head2.next = h2.next;
        
        Node merge = null;
        Node mergeP = null;
        boolean flag = true;
        
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                merge = head1;
                if (flag) {
                    mergeP = merge;
                    flag = false;
                }
                
                merge = merge.next;
                head1 = head1.next;
            } else {
                merge = head2;
                if (flag) {
                    mergeP = merge;
                    flag = false;
                }
                
                merge = merge.next;
                head2 = head2.next;
            }
        }
        
        if (head1 == null) {
            merge = head2;
        } else {
            merge = head1;
        }
        
        return mergeP;
    }
    
    private static void 打印链表(Node head) {
        System.out.println("=========");
        
        while (head != null) {
            System.out.println(head.value + "\t" + head.next);
            head = head.next;
        }
        
        System.out.println("\n=========");
    }
    
    private static Node 递归法(Node h1, Node h2) {
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }
        
        Node head1 = new Node(h1.value);
        head1.next = h1.next;
        Node head2 = new Node(h2.value);
        head2.next = h2.next;
        
        
        Node merge = null;
        
        if (head1.value < head2.value) {
            merge = head1;
            merge.next = 递归法(head1.next, head2);
        } else {
            merge = head2;
            merge.next = 递归法(head1, head2.next);
        }
        
        return merge;
    }
    
    private static Node 生成链表(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        
        String[] strs = str.split(" ");
        
        Node node = new Node(Integer.parseInt(strs[0]));
        Node head = node;
        
        for (int i = 1; i < strs.length; i++) {
            node.next = new Node(Integer.parseInt(strs[i]));
            node = node.next; //指针后移
        }
        
        return head;
    }
}

//定义一个链表的结点类
class Node {
    public int value;
    public Node next = null;
    
    public Node(int value) {
        this.value = value;
    }
    
}
