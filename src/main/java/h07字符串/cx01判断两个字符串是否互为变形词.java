package h07字符串;

import java.util.Scanner;

/**
 * 题目: 给定两个字符串str1和str2, 如果str1和str2中出现的字符串种类一样且每种字符出现的次数也一样,
 * 那么str1和str2互为变形词. 请实现函数判断两个字符串是否互为变形词
 * Created by sharp on 2016/8/22 - 9:28
 */
public class cx01判断两个字符串是否互为变形词 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个字符串");
        String str1 = scanner.nextLine().trim();
        String str2 = scanner.nextLine().trim();
        
        boolean result = isDeformation(str1, str2);
        System.out.println("计算结果为: " + result);
    }
    
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("") ||
                str1.length() != str2.length()) {
            return false;
        }
        
        int[] map = new int[256];
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        
        for(int i = 0; i < str1.length(); i++) {
            map[char1[i]]++;
        }
        
        for(int i = 0; i < str2.length(); i++) {
            if (map[char2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
