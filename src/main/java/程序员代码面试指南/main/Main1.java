package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Input the N: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        method(n);
    }


    private static void method(int n) {
        int[] k = {100, 50, 20, 10, 5, 1};
        int m = calculate(n, k);
        System.out.println(m);
    }

    private static int calculate(int n, int[] k) {
        int count = 0;
        int[] kc = {n / 100, n / 50, n / 20, n / 10, n / 5, n};
        for (int i1 = 0; i1 <= n / 100; i1++) {
            for (int i2 = 0; i2 <= (n - i1 * 100) / 50; i2++) {
                for (int i3 = 0; i3 <= (n - i1 * 100 - i2 * 50) / 20; i3++) {
                    for (int i4 = 0; i4 <= (n - i1 * 100 - i2 * 50 - i3 * 20) / 10; i4++) {
                        for (int i5 = 0; i5 <= (n - i1 * 100 - i2 * 50 - i3 * 20 - i4 * 10) / 5; i5++) {
                            for (int i6 = 0; i6 <= n - i1 * 100 - i2 * 50 - i3 * 20 - i4 * 10 - i5 * 5; i6++) {
                                if (i1 * 100 + i2 * 50 + i3 * 20 + i4 * 10 + i5 * 5 + i6 == n)
                                    count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
