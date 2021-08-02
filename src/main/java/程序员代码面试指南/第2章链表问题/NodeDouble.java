package 程序员代码面试指南.第2章链表问题;

import java.util.ArrayList;

/**
 * 双向链表
 * Created by yw on 7/5 0005.
 */
public class NodeDouble {
    int value;
    NodeDouble up;
    NodeDouble next;
    
    public NodeDouble(int value) {
        this.value = value;
    }
    
    /**
     * 返回双链表的头尾指针
     *
     * @param s 数组字符串
     * @return 链表的头, 尾指针
     */
    static ArrayList<NodeDouble> getNodeDouble(String s) {
        ArrayList<NodeDouble> nodeList = new ArrayList<>();
        String[] split = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s1 : split) {
            Integer integer = new Integer(s1);
            list.add(integer);
        }
        
        NodeDouble node = new NodeDouble(list.get(0));
        node.up = null;
        node.next = null;
        
        NodeDouble head = node;
        
        /**
         * 赋值
         */
        for (int i = 1; i < list.size(); i++) {
            NodeDouble n = new NodeDouble(list.get(i));
            n.up = node;
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
    public static void showNext(ArrayList<NodeDouble> list) {
        NodeDouble head = list.get(0);
        while (head != null) {
            System.out.println("next" + head.next);
            System.out.println("up" + head.up);
            System.out.println(head.value);
            head = head.next;
        }
    }
    
    /**
     * 打印双链表
     */
    public static void showUp(ArrayList<NodeDouble> list) {
        NodeDouble end = list.get(1);
        while (end != null) {
            System.out.println("next" + end.next);
            System.out.println("up" + end.up);
            System.out.println(end.value);
            end = end.up;
        }
    }
}
