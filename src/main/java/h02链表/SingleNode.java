package h02链表;

/**
 * 单向链表
 * Create by @author 杨威 on 2021/7/24 0024 - 18:22
 */
public class SingleNode {
    Integer value;
    SingleNode next;

    public SingleNode(Integer value) {
        this.value = value;
    }

    public SingleNode(Integer value, SingleNode next) {
        this.value = value;
        this.next = next;
    }
}
