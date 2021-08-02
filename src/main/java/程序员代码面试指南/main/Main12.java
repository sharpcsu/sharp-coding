package 程序员代码面试指南.main;

import java.util.Scanner;

/**
 * 题目描述：
 * 给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果。
 * 请求出这些结果中大于m的有多少个。
 * <p>
 * 输入
 * 第一行包含两个整数n, m。
 * 第二行给出n个整数A1, A2, …, An。
 * <p>
 * 输出
 * 输出仅包括一行，即所求的答案。
 * <p>
 * <p>
 * 样例输入
 * 3 10
 * 6 5 10
 * <p>
 * 样例输出
 * 2
 * <p>
 * Created by 杨威 on 9/21 0021 - 19:42
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long[] arr = new long[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((arr[i] ^ arr[j]) > m) {
                    count++;
                }
            }
        }

        System.out.println(count/2);
    }
}
