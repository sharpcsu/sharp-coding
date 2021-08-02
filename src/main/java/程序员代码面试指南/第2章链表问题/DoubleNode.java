package 程序员代码面试指南.第2章链表问题;

/**
 * 双向链表
 * Created by sharp on 7/8 0008 - 14:50
 */
public class DoubleNode {
    int node;
    DoubleNode next; //后向指针
    DoubleNode last; //前向指针

    public DoubleNode(int node) {
        this.node = node;
    }
}
