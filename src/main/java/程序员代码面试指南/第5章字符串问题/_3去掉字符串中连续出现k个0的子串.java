package 程序员代码面试指南.第5章字符串问题;

import java.util.Scanner;

/**
 * 题目: 给定一个字符串str和一个整数k, 如果str中正好有连续的k个'0'字符串出现, 把k个连续的'0'字符去掉,
 * 返回处理后的字符串.
 * Created by sharp on 2016/8/22 - 11:09
 */
public class _3去掉字符串中连续出现k个0的子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = scanner.nextLine().trim();
        System.out.println("请输入一个整数");
        int k = scanner.nextInt();
        
        String result = removeKZeros(str, k);
        System.out.println("计算结果是: " + result);
    }
    
    public static String removeKZeros(String str, int k) {
        if (str == null || str.equals("") || k < 1) {
            return str;
        }
        
        int count = 0;
        int start = -1;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '0') {
                start = (start == -1 ? i : start);
                count++;
            } else {
                if (k == count) {
                    while (count-- > 0)
                        charArr[start++] = 0;
                }
                
                count = 0;
                start = -1;
            }
        }
        
        if (k == count) {
            while (count-- > 0) {
                charArr[start++] = 0;
            }
        }
        return String.valueOf(charArr);
    }
}
