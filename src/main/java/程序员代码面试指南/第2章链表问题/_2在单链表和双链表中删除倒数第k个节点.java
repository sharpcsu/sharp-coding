package 程序员代码面试指南.第2章链表问题;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 分别实现两个函数, 一个可以删除单链表中第K个节点, 令一个可以删除双链表中第k个节点
 * Created by yw on 7/5 0005.
 */
public class _2在单链表和双链表中删除倒数第k个节点 {
    public static void main(String[] args) {
        System.out.println("请输入链表");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //        Node headSingle = Node.getNode(s);
        //        Node.showNext(headSingle);
        ArrayList<NodeDouble> nodeDouble = NodeDouble.getNodeDouble(s);
        NodeDouble.showNext(nodeDouble);
        System.out.println("请输入倒数要删除的节点");
        int k = scanner.nextInt();
        
        //        methodSingle(headSingle, k);
        methodDouble(nodeDouble, k);
    }
    
    /**
     * 在双链表中删除倒数第k个节点
     * @param nodeDouble 双向链表
     * @param k 删除节点的位置
     */
    private static void methodDouble(ArrayList<NodeDouble> nodeDouble, int k) {
        System.out.println("双向链表");
        NodeDouble head = nodeDouble.get(0);
        NodeDouble end = nodeDouble.get(1);
        NodeDouble headTemp = head;
        NodeDouble endTemp = end;
        
        for (int i = 0; i < k; i++) {
            endTemp = endTemp.up;
        }
        headTemp = endTemp;
        for (int i = 0; i < 2; i++) {
            endTemp = endTemp.next;
        }
        
        //删除节点
        headTemp.next = endTemp;
        endTemp.up = headTemp;
        
        NodeDouble.showNext(nodeDouble);
        NodeDouble.showUp(nodeDouble);
    }
    
    /**
     * 在单链表中删除到数第k个节点
     * @param head 单链表
     * @param k 删除节点的位置
     */
    private static void methodSingle(Node head, int k) {
        int size = 0;
        Node temp = head;
        //获取链表的总长度
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        
        temp = head;
        for (int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        
        System.out.println("删除后的结果为:");
        NodeUtils.printLink(head);
    }
}
