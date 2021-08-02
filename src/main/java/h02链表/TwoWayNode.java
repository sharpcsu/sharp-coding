package h02链表;

import java.util.ArrayList;

/**
 * 双向链表
 * Create by @author 杨威 on 2021/8/1 0001 - 21:49
 */
public class TwoWayNode {
    Integer value;
    TwoWayNode prev;
    TwoWayNode next;

    public TwoWayNode(Integer value) {
        this.value = value;
    }

    public TwoWayNode(Integer value, TwoWayNode prev, TwoWayNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    /**
     * 返回双链表的头尾指针
     *
     * @param s 数组字符串
     * @return 链表的头, 尾指针
     */
    static ArrayList<TwoWayNode> getTwoWayNode(String s) {
        ArrayList<TwoWayNode> nodeList = new ArrayList<>();
        String[] split = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s1 : split) {
            Integer integer = new Integer(s1);
            list.add(integer);
        }

        TwoWayNode node = new TwoWayNode(list.get(0));
        node.prev = null;
        node.next = null;

        TwoWayNode head = node;

        /**
         * 赋值
         */
        for (int i = 1; i < list.size(); i++) {
            TwoWayNode n = new TwoWayNode(list.get(i));
            n.prev = node;
            n.next = null;
            node.next = n;
            node = node.next;
        }

        nodeList.add(head);
        nodeList.add(node);
        return nodeList;
    }

    /**
     * 打印双链表
     */
    public static void showNext(ArrayList<TwoWayNode> list) {
        TwoWayNode head = list.get(0);
        while (head != null) {
            System.out.println("next" + head.next);
            System.out.println("up" + head.prev);
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 打印双链表
     */
    public static void showUp(ArrayList<TwoWayNode> list) {
        TwoWayNode end = list.get(1);
        while (end != null) {
            System.out.println("next" + end.next);
            System.out.println("up" + end.prev);
            System.out.println(end.value);
            end = end.prev;
        }
    }
}
