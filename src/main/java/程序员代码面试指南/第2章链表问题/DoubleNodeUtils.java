package 程序员代码面试指南.第2章链表问题;

/**
 * 双向链表的一些公共方法
 * Created by sharp on 2017年7月8日15:02:05
 */
public class DoubleNodeUtils {
    /**
     * 字符串转双向链表
     *
     * @param s 字符串
     * @return 双向链表的头节点
     */
    public static DoubleNode str2doubleNode(String s) {
        String[] ss = s.split(" ");
        DoubleNode head = new DoubleNode(Integer.valueOf(ss[0]));
        DoubleNode doubleNode = head;

        for(int i = 1; i < ss.length; i++) {
            DoubleNode node = new DoubleNode(Integer.valueOf(ss[i]));
            doubleNode.next = node;
            node.last = doubleNode;

            doubleNode = doubleNode.next;
        }

        head.last = doubleNode;
        doubleNode.next = head;

        return head;
    }

    /**
     * 打印
     * @param head
     */
    public static void printDoubleNode(DoubleNode head) {

    }
}
