package 字符串;

import java.util.Scanner;

/**
 * 题目:
 *
 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 
 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 
 测试样例：
 "(()())",6
 返回：true
 测试样例：
 "()a()()",7
 返回：false
 测试样例：
 "()(()()",7
 返回：false
 
 解析:可以做到时间复杂度为O(n), 空间复杂度为O(1), 使用计数器num, 遇到左括号++, 右括号--,num始终为正, 结束时为0;
 * Created by sharp on 2017年7月13日23:37:50
 */
public class nk11合法括号序列判断 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    
        boolean res = chkParenthesis(str, str.length());
        System.out.println("结果为: " + res);
    }
    
    public static boolean chkParenthesis(String A, int n) {
        //合法性判断
        if (A == null || n < 0) {
            return false;
        }
        
        int num = 0;
        for(int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                num++;
            } else if(A.charAt(i) == ')') {
                num--;
            } else {
                return false;
            }
    
            if (num < 0) {
                return false;
            }
        }
    
        return num == 0;
    }
}
