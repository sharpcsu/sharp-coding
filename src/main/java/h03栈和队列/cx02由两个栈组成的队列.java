package h03栈和队列;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 用两个栈实现队列, 支持队列的基本操作(add, poll, peek)
 * Created by yw on 7/5 0005.
 */
public class cx02由两个栈组成的队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        for (String s1 : split) {
            Integer integer = new Integer(s1);
            list.add(integer);
        }
        
        MyQueue queue = new MyQueue();
        for (Integer integer : list) {
            System.out.print(integer+" ");
            queue.push(integer);
        }
        System.out.println();
        
        System.out.println("数据出队列");
        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + "\t");
        }
        
    }
}

