package h02链表;

import java.util.Scanner;

/**
 * 题目:
 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 
 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 
 解析:
 三个思路:
 1. 借助栈
 2.
 3.
 * Created by sharp on 2017/7/18 - 13:48
 */
public class nk07链表的k逆序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
    
        SingleNode head = SingleNodeUtils.str2link(str);
        System.out.println("原始链表");
        SingleNodeUtils.printLink(head);
    
        head = inverse(head, k);
        System.out.println("结果链表");
        SingleNodeUtils.printLink(head);
    }
    
    public static SingleNode inverse(SingleNode head, int k) {
        
        return null;
    }
}
