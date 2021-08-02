package 程序员代码面试指南.第5章字符串问题;

import java.util.Scanner;

/**
 * 题目: 如果一个字符串str, 把字符串str前面任意的部分挪到后面形成的字符串叫作str的旋转词.
 * 比如str = "12345", str的旋转词为12345, 23451, 34512, 45123, 51234.给定两个字符串a和b,
 * 请判断a和b是否为旋转词.
 * <p>
 * Created by sharp on 2016/8/22 - 20:36
 */
public class _4判断两个字符串是否互为旋转词 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个字符串");
        
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        
        boolean result = isRotation(strA, strB);
        System.out.println("计算结果为: " + result);
    }
    
    public static boolean isRotation(String a, String b) {
        if (a == null || b == null || a.equals("") || b.equals("") || a.length() != b.length()) {
            return false;
        }
        
        String a2 = a + a;
        for(int i = 0; i < a.length(); i++) {
            String temp = a2.substring(i, i + a.length());
            if (temp.equals(b)) {
                return true;
            }
        }
        return false;
    }
}
