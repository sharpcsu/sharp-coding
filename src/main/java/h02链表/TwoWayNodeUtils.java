package h02链表;

/**
 * 双向链表的一些公共方法
 * Created by sharp on 2017年7月8日15:02:05
 */
public class TwoWayNodeUtils {
    /**
     * 字符串转双向链表
     *
     * @param s 字符串
     * @return 双向链表的头节点
     */
    public static TwoWayNode str2doubleNode(String s) {
        String[] ss = s.split(" ");
        TwoWayNode head = new TwoWayNode(Integer.valueOf(ss[0]));
        TwoWayNode doubleNode = head;

        for(int i = 1; i < ss.length; i++) {
            TwoWayNode node = new TwoWayNode(Integer.valueOf(ss[i]));
            doubleNode.next = node;
            node.next = doubleNode;

            doubleNode = doubleNode.next;
        }

        head.next = doubleNode;
        doubleNode.next = head;

        return head;
    }

    /**
     * 打印
     * @param head
     */
    public static void printTwoWayNode(TwoWayNode head) {

    }
}
