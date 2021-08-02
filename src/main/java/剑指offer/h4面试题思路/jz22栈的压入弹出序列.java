package 剑指offer.h4面试题思路;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目：输入两个整数序列，每一个序列表示栈的压入顺序，请判断两个序列是否为该栈的弹出序列.
 * 假设压入栈的所有元素都不相等。例如序列1,2,3,4,5是某栈的压入序列，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 * @author sharp
 * 时间:2017-5-30 下午4:30:11
 */
public class jz22栈的压入弹出序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pushStr = scanner.nextLine();
        String popStr = scanner.nextLine();
        
        if(pushStr == null || popStr == null || "".equals(pushStr) || "".equals(popStr)) {
            System.out.println("输入错误");
            return;
        }
        
        ArrayList<Integer> pushArr = 字符串转数组(pushStr);
        ArrayList<Integer> popArr = 字符串转数组(popStr);
        
        boolean flag = 判断弹出序列(pushArr, popArr);
        if (flag) {
            System.out.println("是弹出序列");
        } else {
            System.out.println("不是弹出序列");
        }
    }
    
    private static boolean 判断弹出序列(ArrayList<Integer> pushArr,
                                  ArrayList<Integer> popArr) {
        //输入性检查
        if(pushArr == null || popArr == null || pushArr.size() == 0 || popArr.size() == 0) {
            return false;
        }
        
        boolean flag = false;
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        //出栈序列
        while(popIndex < popArr.size()) {
            //入栈序列
            while(stack.isEmpty() || stack.peek() != popArr.get(popIndex)) {
                if(pushIndex == pushArr.size()) { //入栈结束
                    break;
                }
                
                stack.push(pushArr.get(pushIndex++));
            }
            
            //判断栈顶的值
            if(stack.peek() != popArr.get(popIndex)) {
                break;
            }
            
            stack.pop();
            popIndex++;
            
            if(stack.isEmpty() && popIndex == popArr.size()) {
                flag = true;
            }
            
        }
        
        return flag;
    }
    
    private static ArrayList<Integer> 字符串转数组(String str) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] strs = str.split(" ");
        for(String s : strs) {
            list.add(Integer.parseInt(s));
        }
        
        return list;
    }
}

