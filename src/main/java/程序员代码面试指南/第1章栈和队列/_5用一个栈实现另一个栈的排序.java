package 程序员代码面试指南.第1章栈和队列;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目: 一个栈中元素的类型为整型, 现在想将该栈从栈顶到栈底从大到小的顺序排序,
 * 只需申请一个栈, 除此之外可以申请新的变量, 但不能申请额外的数据结构
 * Created by sharp on 2016/7/8 - 11:00
 */
public class _5用一个栈实现另一个栈的排序 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("请输入数据");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()) {
            throw new RuntimeException("错误, 数据不能为空");
        }
        
        String[] split = s.split(" ");
        for (String s1 : split) {
            stack.push(new Integer(s1));
        }
        
        
        //倒序排序
        method(stack);
        
        System.out.println("排序后数据");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
    
    /**
     * 倒叙排序
     * 时间: 2016/7/8 11:08
     */
    private static void method(Stack<Integer> stack) {
        Stack<Integer> stackTemp = new Stack<>();
        int temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            while (!stackTemp.isEmpty()) {
                if (temp < stackTemp.peek()) {
                    stackTemp.push(temp);
                    break;
                } else {
                    stack.push(stackTemp.pop());
                }
            }
            
            if (stackTemp.isEmpty()) {
                stackTemp.push(temp);
            }
        }
        
        while (!stackTemp.isEmpty()) {
            stack.push(stackTemp.pop());
        }
        
    }
}
