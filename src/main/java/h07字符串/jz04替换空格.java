package h07字符串;

import java.util.Scanner;

/**
 * 题目：
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入"We are happy."，则输出"We%20are%20happy."
 * Create by @author sharpyangwei on 2021/8/2 - 下午8:37
 */
public class jz04替换空格 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();

        char[] arr2 = method(arr);
        System.out.println("输出结果为: ");
        for (char c : arr2) {
            System.out.print(c);
        }
    }

    public static char[] method(char[] arr) {
        int length = arr.length;
        int num = 0;

        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ') {
                num++;
            }
        }

        length = length + num * 2;
        char[] arr2 = new char[length];

        //复制数据
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        int p = length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr2[p--] = '0';
                arr2[p--] = '2';
                arr2[p--] = '%';
            } else {
                arr2[p--] = arr[i];
            }
        }
        return arr2;
    }

}
