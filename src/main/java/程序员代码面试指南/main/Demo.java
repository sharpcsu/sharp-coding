package 程序员代码面试指南.main;

import java.util.LinkedList;

/**
 * Created by 杨威 on 9/19 0019 - 17:14
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("1. size = " + queue.size());

        System.out.println(queue.getFirst());
        System.out.println("2. size = " + queue.size());

        System.out.println(queue.getLast());
        System.out.println("3. size = " + queue.size());

        queue.add(1, 10);
        System.out.println(queue.get(1));
        System.out.println("4. size = " + queue.size());


        System.out.println("5. size = " + queue.size());


        System.out.println("6. size = " + queue.size());
    }
}
