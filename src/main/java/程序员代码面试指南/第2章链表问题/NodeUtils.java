package 程序员代码面试指南.第2章链表问题;

/**
 * 链表操作的一些公共方法。
 *
 * Created by sharp on 7/5 0005 - 22:50
 */
public class NodeUtils {
    /**
     * 打印链表
     * @param head 链表的头节点
     */
    public static void printLink(Node head) {
        System.out.println("打印链表");
        if(head == null) {
            return;
        }

        Node p = head; //重要，移动的指针
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
        System.out.println();
    }
    
    /**
     * 字符串转链表
     * @param s 字符串
     * @return 链表的头节点
     */
    public static Node str2link(String s) {
        //输入合法性校验
        if(s == null || "".equals(s)) {
            return null;
        }

        String[] ss = s.split(" ");

        Node head = new Node(Integer.valueOf(ss[0]));
        Node p = head; //重要，移动的指针

        for(int i = 1; i < ss.length; i++) {
            Node node = new Node(Integer.valueOf(ss[i]));
            p.next = node; //指向新的节点
            p = p.next;//指针后移
        }

        return head;
    }
}
